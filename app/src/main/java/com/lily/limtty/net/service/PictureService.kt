package com.lily.limtty.net.service

import com.lily.limtty.model.classify.PictureClassify
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.net.service
 *
 */

interface PictureService {

    @GET("/v1/vertical/category")
    fun getPictureClassify(): Call<PictureClassify>
}