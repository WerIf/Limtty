package com.lily.myapplication.model.picture.new_pic

import android.view.View

data class Data(
    val ad_id: String,
    val ad_img: String,
    val ad_pos: String,
    val ad_url: String,
    val class_id: String,
    val create_time: String,
    val download_times: String,
    val ext_1: String,
    val ext_2: String,
    val id: String,
    val img_1024_768: String,
    val img_1280_1024: String,
    val img_1280_800: String,
    val img_1366_768: String,
    val img_1440_900: String,
    val img_1600_900: String,
    val imgcut: String,
    val rdata: List<Any>,
    val resolution: String,
    val tag: String,
    val tempdata: String,
    val update_time: String,
    val url: String,
    val url_mid: String,
    val url_mobile: String,
    val url_thumb: String,
    val utag: String
){

    fun onclick(view: View){

    }
}