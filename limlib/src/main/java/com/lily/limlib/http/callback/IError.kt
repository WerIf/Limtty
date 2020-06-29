package com.lily.myapplication.net.callback

interface IError {
    fun onErrorImpl(code:Int,failed:String)
}