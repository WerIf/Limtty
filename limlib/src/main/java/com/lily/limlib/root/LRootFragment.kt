package com.lily.limlib.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.lily.limlib.tools.LTagTools

/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limlib
 *
 */
open abstract class LRootFragment<L:ViewDataBinding>:Fragment() {
    //是否是重新加载
    private var isReload=false
    //Navigation页面控制器
    lateinit var fController:NavController

    lateinit var binding:L


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        LTagTools.d("${this::binding.isInitialized}")
        if(!this::binding.isInitialized){
            fController=NavHostFragment.findNavController(this)
            binding=DataBindingUtil.inflate<L>(inflater,getContentId(),container,false)
            isReload=true
            initOperation()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(isReload){
            initL()

            initE()

            isReload=false
        }
    }

    abstract fun getContentId(): Int

    open protected fun initOperation(){}

    //初始化数据
    abstract fun initL()

    //初始化事件
    abstract fun initE()

    //初始化Toolbar页面返回事件
    protected fun initToolBarEvent(toolbar:Toolbar){
        toolbar.setNavigationOnClickListener {
            fController.popBackStack()
        }
    }


}