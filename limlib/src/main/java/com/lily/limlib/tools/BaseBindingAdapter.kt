package com.lily.limlib.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList.OnListChangedCallback
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding4.view.clicks
import java.util.concurrent.TimeUnit


/**
 * Created by Werif
 * Created on 2020/7/27
 * PackageName com.lily.limlib.tools
 *
 */
abstract class BaseBindingAdapter<M, B : ViewDataBinding> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected lateinit var onClickItem: (index: Int, data: M) -> Unit

    var items: ObservableArrayList<M>
    var itemsChangeCallback: ListChangedCallback

    //item 点击事件
    fun initClickEvent(onItem: (index:Int, data:M) -> Unit) {
        onClickItem = onItem
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: B = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getLayoutResId(viewType),
            parent,
            false
        )
        return BaseBindingViewHolder(binding.root)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val binding: B? = DataBindingUtil.getBinding(holder.itemView)
        binding?.run {
            if (::onClickItem.isInitialized)
                binding.root.clicks().throttleFirst(2, TimeUnit.SECONDS).subscribe {
                    onClickItem(position, items[position])
                }
            onBindItem(this, items[position])
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        items.addOnListChangedCallback(itemsChangeCallback)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        items.removeOnListChangedCallback(itemsChangeCallback)
    }

    //region 处理数据集变化
    protected fun onChanged(newItems: ObservableArrayList<M>) {
        resetItems(newItems)
        notifyDataSetChanged()
    }

    protected fun onItemRangeChanged(
        newItems: ObservableArrayList<M>,
        positionStart: Int,
        itemCount: Int
    ) {
        resetItems(newItems)
        notifyItemRangeChanged(positionStart, itemCount)
    }

    protected fun onItemRangeInserted(
        newItems: ObservableArrayList<M>,
        positionStart: Int,
        itemCount: Int
    ) {
        resetItems(newItems)
        notifyItemRangeInserted(positionStart, itemCount)
    }

    protected fun onItemRangeMoved(newItems: ObservableArrayList<M>) {
        resetItems(newItems)
        notifyDataSetChanged()
    }

    protected fun onItemRangeRemoved(
        newItems: ObservableArrayList<M>,
        positionStart: Int,
        itemCount: Int
    ) {
        resetItems(newItems)
        notifyItemRangeRemoved(positionStart, itemCount)
    }

    protected fun resetItems(newItems: ObservableArrayList<M>) {
        items = newItems
    }

    //endregion
    @LayoutRes
    protected abstract fun getLayoutResId(viewType: Int): Int

    protected abstract fun onBindItem(binding: B, item: M)
    inner class ListChangedCallback :
        OnListChangedCallback<ObservableArrayList<M>>() {
        override fun onChanged(newItems: ObservableArrayList<M>) {
            this@BaseBindingAdapter.onChanged(newItems)
        }

        override fun onItemRangeChanged(
            newItems: ObservableArrayList<M>,
            i: Int,
            i1: Int
        ) {
            this@BaseBindingAdapter.onItemRangeChanged(newItems, i, i1)
        }

        override fun onItemRangeInserted(
            newItems: ObservableArrayList<M>,
            i: Int,
            i1: Int
        ) {
            this@BaseBindingAdapter.onItemRangeInserted(newItems, i, i1)
        }

        override fun onItemRangeMoved(
            newItems: ObservableArrayList<M>,
            i: Int,
            i1: Int,
            i2: Int
        ) {
            this@BaseBindingAdapter.onItemRangeMoved(newItems)
        }

        override fun onItemRangeRemoved(
            sender: ObservableArrayList<M>,
            positionStart: Int,
            itemCount: Int
        ) {
            this@BaseBindingAdapter.onItemRangeRemoved(sender, positionStart, itemCount)
        }
    }

    init {
        items = ObservableArrayList()
        itemsChangeCallback = ListChangedCallback()
    }
}