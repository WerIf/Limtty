package com.lily.limtty.page.pic.pic_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lily.limtty.repository.picture.PictureDetailsRepository

/**
 * Created by Werif
 * Created on 2020/7/28
 * PackageName com.lily.limtty.page.pic.pic_details
 *
 */
class PictureDetailsModelFactory(private val repository: PictureDetailsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PicDetailsViewModel(repository) as T
    }
}