package com.lily.limtty.intercepter

import android.util.Log
import com.lily.limtty.LogTool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by Werif
 * Created on 2020/7/2
 * PackageName com.lily.limtty.intercepter
 *
 */
class LHttpInterceptor {



    companion object {
        var client: OkHttpClient.Builder = OkHttpClient.Builder()
        //读取超时
        private var readTimeOut = 10L
        //连接超时
        private var connectTimeout = 10L
        //写入超时
        private var writeTimeout = 10L

        val DEFAULT: OkHttpClient by lazy {

            var loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String?) {

                    LogTool.v("LHttpInterceptor", "Interceptor data is:$message")
                }

            })

            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


            val build = client.readTimeout(readTimeOut, TimeUnit.SECONDS)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
            build
        }
    }
}