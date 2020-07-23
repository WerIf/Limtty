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
    private const val BASE_URL="http://service.picasso.adesk.com"

//    private val httpClient=OkHttpClient.Builder()

    private val builder=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(LHttpInterceptor.DEFAULT)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit= builder.build()

    fun <T> create(serviceClass:Class<T>):T= retrofit.create(serviceClass)
}