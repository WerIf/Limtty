package com.lily.limtty

import com.lily.limlib.root.LRootActivity
import com.lily.limlib.window.StatusBarUtil
import com.lily.limtty.databinding.ActivityMainBinding

class MainActivity : LRootActivity<ActivityMainBinding>() {
    override fun getContentId(): Int = R.layout.activity_main

    override fun initL() {
        StatusBarUtil.setStatusBarColor(this, R.color.theme_color)

    }
}
