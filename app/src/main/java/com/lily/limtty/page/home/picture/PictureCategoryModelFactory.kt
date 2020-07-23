package com.lily.limtty.page.home.picture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lily.limtty.repository.PictureCategoryRepository

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.page.home.picture
 *
 */
class PictureCategoryModelFactory(private val repository: PictureCategoryRepository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PictureViewModel(repository) as T
    }
}