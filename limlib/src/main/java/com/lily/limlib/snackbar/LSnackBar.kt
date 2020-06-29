package com.lily.limlib.snackbar

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.lily.limlib.R
import com.lily.limlib.snackbar.bar.BaseTransientBottomBar
import com.lily.limlib.snackbar.bar.TopSnackBar
import com.lily.limlib.tools.LTagTools
import com.lily.limlib.tools.ViewMetrics


/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limlib.snackbar
 *
 */
class LSnackBar {
    companion object{
        fun mack(view: View, message:String, hModel:Int=-1, duration:Int= BaseTransientBottomBar.LENGTH_SHORT):TopSnackBar{

            val lBar=TopSnackBar.make(view,message,duration)
            var snackBarLayout=lBar.view
            snackBarLayout.alpha = 0.5f;//包括了文本的透明度！323532
            snackBarLayout.setBackgroundResource(R.drawable.shape_snackbar);
            var params = snackBarLayout.layoutParams as FrameLayout.LayoutParams
            var ll = ViewGroup.MarginLayoutParams(params.width, params.height)
            ll.setMargins(20, 30, 20, 0)
            snackBarLayout.layoutParams = ll

            val textView =
                snackBarLayout.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
           when(hModel){
               0->{
                   textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_success, 0, 0, 0)
               }
               1->{
                   textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_faile, 0, 0, 0)
               }
               2->{
                   textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_hint, 0, 0, 0)
               }
           }
            textView.compoundDrawablePadding =20
            textView.setTextColor(Color.WHITE)
            lBar.show()
            return lBar
        }
    }
}