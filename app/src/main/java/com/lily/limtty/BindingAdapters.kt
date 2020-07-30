package com.lily.limtty

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

/**
 * Created by Werif
 * Created on 2020/7/23
 * PackageName com.lily.limtty
 *
 */
fun windowWidth(context: Context)=context.resources.displayMetrics.widthPixels

@BindingAdapter("bind:colorSchemeResources")
fun SwipeRefreshLayout.colorSchemeResources(resId: Int) {
    setColorSchemeResources(resId)
}


@BindingAdapter("bind:loadBingPic")
fun ImageView.loadImage(url:String){

//    var scale=(windowWidth(this.context)/2)/640

    var image=this
    var rounder=RoundedCorners(10)
    var option=RequestOptions.bitmapTransform(rounder)
    Glide.with(context)
        .asBitmap()
        .load(url)
        .apply(option)
        .into(object:SimpleTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                image.adjustViewBounds=true
                image.setImageBitmap(resource)
            }

        })
}