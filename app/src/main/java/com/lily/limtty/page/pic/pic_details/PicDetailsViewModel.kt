package com.lily.limtty.page.pic.pic_details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.lily.limtty.model.pic_details.Vertical
import com.lily.limtty.repository.picture.PictureDetailsRepository

/**
 * Created by Werif
 * Created on 2020/7/28
 * PackageName com.lily.limtty.page.pic.pic_details
 *
 */
class PicDetailsViewModel(private val  repository: PictureDetailsRepository) :ViewModel(){

    var dataList= MutableLiveData<PagedList<Vertical>>()
    var refreshing=MutableLiveData<Boolean>()

    fun getPidDetails(pId:String)=let {
        Log.v("Tag_____","is running step 1")
        repository.getPicDetails(pId)
    }


    fun refreshingDetails(pId:String){
        refreshing.value=true
        getPidDetails(pId)
        refreshing.value=false
    }
}