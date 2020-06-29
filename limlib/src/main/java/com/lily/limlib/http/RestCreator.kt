package com.lily.myapplication.net

import android.util.Log
import com.google.gson.Gson
import com.lily.limlib.http.RestService
import com.lily.myapplication.tools.LenientGsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestCreator {
    companion object {

        private val builder: OkHttpClient by lazy {



            //拦截器
//            var interceptor=object:Interceptor{
//                override fun intercept(chain: Interceptor.Chain): Response {
//
//                    chain.connection().
//
//                    return chain.proceed()
//                }
//            }

            var loggingInterceptor=HttpLoggingInterceptor(object:HttpLoggingInterceptor.Logger{
                override fun log(message: String?) {

                    Log.i("TAG","print current tag is:$message")
                }

            })

            loggingInterceptor.level=HttpLoggingInterceptor.Level.BODY


            var client = OkHttpClient.Builder()
            val build = client.readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
            build
        }


        private class RetrofitHolder {
            companion object {
                var RETROFIT_CLIENT = Retrofit.Builder()
                    .baseUrl(UrlManage.Base_Url)
                    .client(builder)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()


                var RETROFIT_BOOK = Retrofit.Builder()
                    .baseUrl(UrlManage.Book_Url)
                    .client(builder)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                //章节
                var RETROFIT_CHAPTER = Retrofit.Builder()
                    .baseUrl(UrlManage.Book_Chapter)
                    .client(builder)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                //文章详情
                var RETROFIT_ARTICLE = Retrofit.Builder()
                    .baseUrl(UrlManage.Book_Article)
                    .client(builder)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                //漫画
                var RETROFIT_CARTOON= Retrofit.Builder()
                    .baseUrl(UrlManage.Cartoon)
                    .client(builder)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                //图片 1
                var RETROFIT_PICTURE= Retrofit.Builder()
                    .baseUrl(UrlManage.Picture)
                    .client(builder)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                var RETROFIT_PICTURE_2= Retrofit.Builder()
                    .baseUrl(UrlManage.Picture1)
                    .client(builder)
//                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(LenientGsonConverterFactory.create(Gson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
        }

        private class RestServiceHolder {
            companion object {
                var REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create(RestService::class.java)

                var BOOK_SERVICE = RetrofitHolder.RETROFIT_BOOK.create(RestService::class.java)

                var CHAPTER_SERVICE =
                    RetrofitHolder.RETROFIT_CHAPTER.create(RestService::class.java)

                var ARTICLE_SERVICE =
                    RetrofitHolder.RETROFIT_ARTICLE.create(RestService::class.java)

                var CARTOON_SERVICE =
                        RetrofitHolder.RETROFIT_CARTOON.create(RestService::class.java)

                var PICTURE_SERVICE =
                    RetrofitHolder.RETROFIT_PICTURE.create(RestService::class.java)

                var PICTURE_SERVICE_2=
                    RetrofitHolder.RETROFIT_PICTURE_2.create(RestService::class.java)
            }
        }

        fun getRestService(): RestService {
            return RestServiceHolder.REST_SERVICE
        }


        fun getBookService(): RestService {
            return RestServiceHolder.BOOK_SERVICE
        }

        fun getChapterService(): RestService {
            return RestServiceHolder.CHAPTER_SERVICE
//            return RestServiceHolder.BOOK_SERVICE
        }

        fun getArticleService(): RestService {
            return RestServiceHolder.ARTICLE_SERVICE
        }

        fun getCartoonService(): RestService {
            return RestServiceHolder.CARTOON_SERVICE
        }

        fun getPictureService(tag:String="old"): RestService {

            return if(tag=="old"){
                RestServiceHolder.PICTURE_SERVICE
            }else {
                RestServiceHolder.PICTURE_SERVICE_2
            }

        }

    }
}