package com.lily.limtty.page.home.view

import androidx.databinding.ViewDataBinding
import com.lily.limtty.R

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limtty.page.home.view
 *
 */
class PageView<T:ViewDataBinding> private constructor(): LBaseView<T>() {
    companion object Instance{
       fun<T:ViewDataBinding> instance():PageView<T>{
           var info=PageView<T>()
           return info
       }
    }

    //创建View
    override fun getContentId(): Int =R.layout.layout_page_view

}