package com.lily.limtty.page.home.picture

import androidx.databinding.ViewDataBinding
import com.lily.limtty.R
import com.lily.limtty.page.home.LBaseView

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limtty.page.home.view
 *
 */
class PictureView<T:ViewDataBinding> private constructor(): LBaseView<T>() {
    companion object Instance{
       fun<T:ViewDataBinding> instance(): PictureView<T> {
           var info= PictureView<T>()
           return info
       }
    }

    //创建View
    override fun getContentId(): Int =R.layout.layout_page_view

}