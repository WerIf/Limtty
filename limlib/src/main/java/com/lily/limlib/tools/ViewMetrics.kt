package com.lily.limlib.tools

import android.content.Context

/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limlib.tools
 *
 */
class ViewMetrics {
    companion object{
        private var lWidth=0
        private var lHeight=0
        fun width(context:Context):Int{
            if(lWidth!=0)
            else {
                lWidth=context.resources.displayMetrics.widthPixels
            }
            return lWidth
        }

        fun height(context:Context):Int{
            if(lHeight!=0)
            else {
                lHeight=context.resources.displayMetrics.heightPixels
            }
            return lHeight
        }
    }
}