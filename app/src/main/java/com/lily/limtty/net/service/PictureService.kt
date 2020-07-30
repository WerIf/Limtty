package com.lily.limtty.net.service

import com.lily.limtty.model.pic_category.PictureCategory
import com.lily.limtty.model.pic_details.PictureDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.net.service
 *
 */

interface PictureService {

    @GET("/v1/vertical/category")
    fun getPictureClassify(): Call<PictureCategory>


    @GET("/v1/vertical/category/{id}/vertical")
    fun getPictureList(
        @Path("id") id: String,
        @Query("first") first: Int,
        @Query("limit") limit: Int = 30,
        @Query("skip") skip: Int, @Query("adult") adult: Boolean = true, @Query("order") order: String = "hot"
    ): Call<PictureDetails>


}