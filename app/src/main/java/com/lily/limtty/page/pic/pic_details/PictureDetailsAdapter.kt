package com.lily.limtty.page.pic.pic_details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lily.limtty.BR
import com.lily.limtty.R
import com.lily.limtty.databinding.LayoutDetailsImageBinding
import com.lily.limtty.model.pic_details.Vertical

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty.page.pic
 *
 */
class PictureDetailsAdapter:PagedListAdapter<Vertical,PictureDetailsAdapter.PictureDetailsHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK=object : DiffUtil.ItemCallback<Vertical>(){
            override fun areItemsTheSame(oldItem: Vertical, newItem: Vertical): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Vertical, newItem: Vertical): Boolean =
                oldItem == newItem
        }
    }

    inner class PictureDetailsHolder(var binding:LayoutDetailsImageBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureDetailsHolder {
            var binding=DataBindingUtil.inflate<LayoutDetailsImageBinding>(parent.context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                R.layout.layout_details_image,parent,false)
        return PictureDetailsHolder(binding)
    }

    override fun onBindViewHolder(holder: PictureDetailsHolder, position: Int) {
        holder.binding.setVariable(BR.detailsData,getItem(position))
    }
}