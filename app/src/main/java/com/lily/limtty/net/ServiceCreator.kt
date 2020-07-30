package com.lily.limtty.net

import com.lily.limtty.intercepter.LHttpInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limlib.http
 *
 */
object ServiceCreator {
    private const val BASE_PICTURE="http://service.picasso.adesk.com"
    private const val BASE_COMIC="https://gateway.marvel.com"


    private val pictureBuilder=Retrofit.Builder()
        .baseUrl(BASE_PICTURE)
        .client(LHttpInterceptor.DEFAULT)
        .addConverterFactory(GsonConverterFactory.create())

    private val comicBuilder=Retrofit.Builder()
        .baseUrl(BASE_COMIC)
        .client(LHttpInterceptor.DEFAULT)
        .addConverterFactory(GsonConverterFactory.create())

    private val pictureRetrofit= pictureBuilder.build()
    private val comicRetrofit= comicBuilder.build()

    fun <T> createPicture(serviceClass:Class<T>):T= pictureRetrofit.create(serviceClass)
    fun <T> createComic(serviceClass:Class<T>):T= comicRetrofit.create(serviceClass)
}