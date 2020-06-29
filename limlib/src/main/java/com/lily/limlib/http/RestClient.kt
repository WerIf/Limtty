package com.lily.limlib.http

import androidx.lifecycle.MutableLiveData
import com.lily.myapplication.net.RestCreator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import java.io.File
import io.reactivex.Observable


class RestClient<F>(
    var lParam: MutableMap<String, Any>?,
    var lUrl: String?,
    var lRequest_Start: () -> Unit?,
    var lRequest_End: () -> Unit?,
    var lSuccess: (MutableLiveData<F>) -> Unit?,
    var lFailure: (String) -> Unit?,
    var lError: (Int, String) -> Unit?,
    var lBody: RequestBody?,
    var lFile: File?,
    var lDownload_Dir: String?,
    var lExtension: String?,
    var lFileName: String?
) {

    private val TAG = RestClient::class.java.name

    companion object {
        fun <F> create(): RestClientBuilder<F> {
            return RestClientBuilder()
        }
    }

    fun <C> request(methodName:String,clazz:Class<C>) {
        if (lRequest_Start != null) {
            lRequest_Start()
        }
        var service = RestCreator.getBookService()
        var method=service::class.java.getDeclaredMethod(methodName,clazz)
        var data=method.invoke(service,lParam)as Observable<F>
        platform(data)
    }

    private fun platform(observable: Observable<F>) {
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (lSuccess != null) {
                    var liveData = MutableLiveData<F>()
                    liveData.postValue(it)
                    lSuccess(liveData)
                }
            }, {
                if (lFailure != null) {
                    lFailure(it.message!!)
                }
            }, {
                if (lRequest_End != null) {
                    lRequest_End()
                }
            })
    }


}




