package com.lily.limlib.http

import androidx.lifecycle.MutableLiveData
import com.lily.limlib.http.type.ClientBuilder
import okhttp3.MediaType
import okhttp3.RequestBody
import java.io.File

class RestClientBuilder<F> {
    private var mParams: MutableMap<String, Any>? = null
    private var mUrl: String? = null
    private var startImpl: () -> Unit={}
    private var endImpl: () -> Unit={}

    private var mSuccess = { success: MutableLiveData<F> -> Unit }
    private var mFailure = { failure: String -> Unit}
    private var mError = { code: Int, error: String -> Unit }
    private var mBody: RequestBody? = null

    private var mFile: File? = null
    private var mDownloadDir: String? = null
    private var mExtension: String? = null
    private var mFileName: String? = null
    private var builder: ClientBuilder? = null

    fun url(url: String): RestClientBuilder<F> {
        this.mUrl = url
        return this
    }

    fun params(params: MutableMap<String, Any>): RestClientBuilder<F> {
        this.mParams = params
        return this
    }


    fun sRequest(requestStart: () ->Unit): RestClientBuilder<F> {
        this.startImpl=requestStart
        return this
    }
    fun eRequest(requestEnd:() ->Unit): RestClientBuilder<F> {
        this.endImpl=requestEnd
        return this
    }

    fun success(success: (MutableLiveData<F>) -> Unit): RestClientBuilder<F> {
        this.mSuccess = success
        return this
    }

    fun failure(failure: (String) -> Unit): RestClientBuilder<F> {
        this.mFailure = failure
        return this
    }

    fun error(error: (Int, String) -> Unit): RestClientBuilder<F> {
        this.mError = error
        return this
    }

    fun raw(raw: String): RestClientBuilder<F> {
        this.mBody = RequestBody.create(
            MediaType.parse("application/json;charset=UTF-8"), raw
        )
        return this
    }

    fun file(file: File): RestClientBuilder<F> {
        this.mFile = file
        return this
    }

    fun file(file: String): RestClientBuilder<F> {
        this.mFile = File(file)
        return this
    }

    fun dir(dir: String): RestClientBuilder<F> {
        this.mDownloadDir = dir
        return this
    }

    fun extension(extension: String): RestClientBuilder<F> {
        this.mExtension = extension
        return this
    }

    fun filename(filename: String): RestClientBuilder<F> {
        this.mFileName = filename
        return this
    }

    fun buildFactory(builder: ClientBuilder): RestClientBuilder<F> {
        this.builder = builder
        return this
    }

    fun build(): RestClient<F> {
        return RestClient(
            mParams,
            mUrl,
            startImpl,
            endImpl,
            mSuccess,
            mFailure,
            mError,
            mBody,
            mFile,
            mDownloadDir,
            mExtension,
            mFileName
        )
    }
}