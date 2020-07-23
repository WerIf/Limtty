package com.lily.limtty

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * Created by Werif
 * Created on 2020/7/23
 * PackageName com.lily.limtty
 *
 */
object LogTool {
    fun v(tag: String="Tag_____",data:String ){
        Log.v(tag,data)
    }
}