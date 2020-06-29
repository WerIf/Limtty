package com.lily.limlib.root

import android.content.ClipData.Item
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lily.limlib.http.RestClient


/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limlib.root
 *
 */
abstract class LViewModelImpl<T>:ViewModel() {
    private val lBean = MutableLiveData<T>()

    fun init(lFragment:Fragment){
        val builder=RestClient.create<T>()
    }
}