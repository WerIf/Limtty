package com.lily.limtty

import android.widget.Toast

/**
 * Created by Werif
 * Created on 2020/7/23
 * PackageName com.lily.limtty
 *
 */
object ToastTool {
    fun show(data: String?) {
        Toast.makeText(LApplication.context, data, Toast.LENGTH_SHORT).show()
    }
}