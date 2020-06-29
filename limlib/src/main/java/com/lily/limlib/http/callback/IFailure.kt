package com.lily.myapplication.net.callback

interface IFailure {
    fun onFailureImpl(code:Int,failure:String?)
}