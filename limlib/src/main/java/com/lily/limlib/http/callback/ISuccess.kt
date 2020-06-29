package com.lily.myapplication.net.callback

import androidx.lifecycle.MutableLiveData

interface ISuccess<F> {
    fun onSuccessImpl(t: MutableLiveData<F>)
}