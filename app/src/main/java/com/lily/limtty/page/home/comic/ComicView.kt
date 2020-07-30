package com.lily.limtty.page.home.comic

import androidx.databinding.ViewDataBinding
import com.lily.limtty.R
import com.lily.limtty.page.home.LBaseView

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limtty.page.home.view
 *
 */
 class ComicView<T:ViewDataBinding> private constructor() :
    LBaseView<T>(){
    companion object Instance{
        fun<T:ViewDataBinding> instance(): ComicView<T> {
            var info= ComicView<T>()
            return info
        }
    }

    override fun getContentId(): Int =R.layout.layout_collect_view

}