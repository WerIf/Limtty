package com.lily.limlib.http.type

import io.reactivex.Observable

abstract class ClientBuilder {
    abstract fun <F>  platform(PARAMS: MutableMap<String, Any>?):Observable<F>?

}