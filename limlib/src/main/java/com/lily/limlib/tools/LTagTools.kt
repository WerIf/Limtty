package com.lily.limlib.tools

import android.util.Log

/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limtty.tools
 *
 */
class LTagTools {
    companion object{
        fun v(key:String,value:String){
            Log.v(key,value)
        }

        fun e(key:String,value:String){
            Log.e(key,value)
        }

        fun d(value:String){
            Log.d("Log___Default",value)
        }
    }
}