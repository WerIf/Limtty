package com.lily.limtty.page.home.view

import android.content.Context
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limtty.page.home.view
 *
 */
abstract class LBaseView<T : ViewDataBinding> {

    private lateinit var binding: T
    fun createBinding(context: Context): T {
        if (!this::binding.isInitialized) {
            var inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            binding = DataBindingUtil.inflate<T>(inflater, getContentId(), null, false)
        }
        return binding
    }

    abstract fun getContentId(): Int
}