package com.lily.limtty.page.home.picture

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.lily.limtty.LApplication
import com.lily.limtty.LogTool
import com.lily.limtty.ToastTool
import com.lily.limtty.model.pic_category.Category
import com.lily.limtty.repository.picture.PictureCategoryRepository
import kotlinx.coroutines.launch

/**
 * Created by Werif
 * Created on 2020/7/2
 * PackageName com.lily.limtty.view_model
 *
 */
class PictureViewModel(private val repository: PictureCategoryRepository):ViewModel() {
    var categoryList=MutableLiveData<List<Category>>()

    var refreshing=MutableLiveData<Boolean>()

    fun getCategory(){
        launch({
            categoryList.value=repository.getCategory()
            LogTool.v(data = Gson().toJson(categoryList.value))

        },{
            Toast.makeText(LApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
    }

    fun refreshCategory(){

        refreshing.value=true
        launch({
            categoryList.value=repository.refreshCategory()
            refreshing.value = false
        },{
           ToastTool.show(it.message)
            refreshing.value = false
        })
    }

    private fun launch(block:suspend ()->Unit, error: suspend (Throwable) -> Unit)=viewModelScope.launch {
        try {
            block()
        } catch (e: Throwable) {
            error(e)
        }
    }

}