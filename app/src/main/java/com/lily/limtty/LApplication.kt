package com.lily.limtty

import android.app.Application
import android.content.Context
import com.lily.limtty.util.InjectorUtil

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limtty
 *
 */
class LApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        InjectorUtil.init(this)
        context=this
    }

    companion object{
        lateinit var context:Context
    }
}