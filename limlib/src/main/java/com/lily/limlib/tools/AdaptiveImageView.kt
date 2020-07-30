package com.lily.limlib.tools

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import kotlin.math.ceil

/**
 * Created by Werif
 * Created on 2020/7/27
 * PackageName com.lily.limlib.tools
 *
 */
class AdaptiveImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
      if(drawable!=null){

          var width = MeasureSpec.getSize(widthMeasureSpec)

          var height = ceil(width.toFloat() * drawable.intrinsicHeight / drawable.intrinsicWidth).toInt()

          setMeasuredDimension(width, height)

      }else{
          super.onMeasure(widthMeasureSpec, heightMeasureSpec)
      }
    }
}