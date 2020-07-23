package com.lily.limtty.net

import com.lily.limtty.LogTool
import com.lily.limtty.net.service.PictureService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    private val pictureService=ServiceCreator.create(PictureService::class.java)

    suspend fun fetchPictureClassifyList()=pictureService.getPictureClassify().await()

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