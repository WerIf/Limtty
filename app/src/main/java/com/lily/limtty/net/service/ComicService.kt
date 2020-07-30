package com.lily.limtty.net.service

import com.lily.limtty.model.comic.ComicInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty.net.service
 *
 */
interface ComicService {
    @GET("/v1/public/comics")
    fun comicCategory(@QueryMap cParam:MutableMap<String,Any>): Call<ComicInfo>

    @GET("/v1/public/creators")
    fun comicCreators(@QueryMap cParam:MutableMap<String,Any>):Call<ComicInfo>
}