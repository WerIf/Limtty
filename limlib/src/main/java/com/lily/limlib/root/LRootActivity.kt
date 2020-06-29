package com.lily.limlib.root

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limlib
 *
 */
abstract class LRootActivity<L : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<L>(this, getContentId())
        initL()
    }

    abstract fun getContentId(): Int


    abstract fun initL()

}