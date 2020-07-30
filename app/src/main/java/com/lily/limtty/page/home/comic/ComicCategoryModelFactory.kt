package com.lily.limtty.page.home.comic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lily.limtty.repository.comic.ComicCategoryRepository

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty.page.home.comic
 *
 */
class ComicCategoryModelFactory(private val comicCategoryRepository: ComicCategoryRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicCategoryViewModel(comicCategoryRepository) as T
    }
}