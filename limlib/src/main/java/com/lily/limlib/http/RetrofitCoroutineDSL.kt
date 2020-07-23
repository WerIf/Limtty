package com.lily.limlib.http

import retrofit2.Call

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limlib.http
 *
 */
class RetrofitCoroutineDSL<T> {

    var api:(Call<Result<T>>)?=null
    var onSuccess:((T)->Unit)?=null
        private set
    var onFail: ((msg: String, errorCode: Int) -> Unit)? = null
        private set
    var onComplete:(()->Unit)?=null
        private set

    fun onSuccess(block:(T)->Unit){
        this.onSuccess=block
    }

    fun onFail(block:(String,Int)->Unit){
        this.onFail=block
    }

    fun onComplete(block:()->Unit){
        this.onComplete=block
    }

    fun clean(){
        onSuccess = null
        onComplete = null
        onFail = null
    }
}