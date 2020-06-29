package com.lily.limtty.page.home.view

import android.content.Context
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lily.limtty.R
import com.lily.limtty.databinding.LayoutPageViewBinding

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limtty.page.home.view
 *
 */
 class CollectionView<T:ViewDataBinding> private constructor() :LBaseView<T>(){
    companion object Instance{
        fun<T:ViewDataBinding> instance():CollectionView<T>{
            var info=CollectionView<T>()
            return info
        }
    }

    override fun getContentId(): Int =R.layout.layout_collect_view

}