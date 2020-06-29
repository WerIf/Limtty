package com.lily.limtty.page.home.view

import androidx.databinding.ViewDataBinding
import com.lily.limtty.R

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limtty.page.home.view
 *
 */
class ShareView<T:ViewDataBinding> private constructor():LBaseView<T>() {
    companion object {
        fun <T:ViewDataBinding> instance():ShareView<T>{
            var info=ShareView<T>()
            return info
        }
    }
    override fun getContentId(): Int = R.layout.layout_share_view
}