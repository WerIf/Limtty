package com.lily.myapplication.net.callback

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IRequestCallback<F>(
    val REQUEST: IRequest,
    val SUCCESS: ISuccess<F>,
    val FAILURE: IFailure,
    val ERROR: IError
): Callback<F> {
    override fun onFailure(call: Call<F>, t: Throwable) {
        FAILURE.onFailureImpl(t.message!!)
    }

    override fun onResponse(call: Call<F>, response: Response<F>) {

        if(response.isSuccessful){
            if(call.isExecuted){
                //创建LiveData容器
                var liveData= MutableLiveData<F>()
                //将请求结果添加到容器中
                liveData.postValue(response.body())
                SUCCESS.onSuccessImpl(liveData)
            }
        }else{
            ERROR.onErrorImpl(response.code(),response.message())
        }
    }


}