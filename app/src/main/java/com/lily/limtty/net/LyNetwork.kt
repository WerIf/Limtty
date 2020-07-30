package com.lily.limtty.net

import com.lily.limtty.LogTool
import com.lily.limtty.net.service.ComicService
import com.lily.limtty.net.service.PictureService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limlib.http
 *
 */
class LyNetwork {

    private val pictureService=ServiceCreator.createPicture(PictureService::class.java)
    private val comicService=ServiceCreator.createComic(ComicService::class.java)

    //图片分类列表
    suspend fun fetchPictureClassifyList()=pictureService.getPictureClassify().await()
    //图片详情
    suspend fun fetchPicDetailsList(id:String,startIndex:Int,skip:Int)=pictureService.getPictureList(id = id,first = startIndex,skip = skip).await()

    //漫画分类
    suspend fun fetchComicList(cParam:MutableMap<String,Any>)=comicService.comicCategory(cParam).await()

    suspend fun fetchComicCreators(cParam:MutableMap<String,Any>)=comicService.comicCreators(cParam).await()

    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine {continuation->
            enqueue(object:Callback<T>{
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body=response.body()
                    if(body!=null)continuation.resume(body)
                }

            })

        }
    }


    companion object{
        private var lyNetwork: LyNetwork?=null

        fun getInstance(): LyNetwork {
            if(lyNetwork ==null){
                synchronized(LyNetwork::class.java){
                    if(lyNetwork ==null){
                        lyNetwork =
                            LyNetwork()
                    }
                }
            }
            return lyNetwork!!
        }
    }
}