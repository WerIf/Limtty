package com.lily.limtty.repository.comic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lily.limtty.net.LyNetwork
import com.lily.limtty.page.home.comic.ComicCategoryViewModel

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty.repository.comic
 *
 */
class ComicCategoryRepository(private val network: LyNetwork) {

    suspend fun getComicCategory(cParam:MutableMap<String,Any>)=network.fetchComicList(cParam)

    suspend fun getComicCreators(cParam:MutableMap<String,Any>)=network.fetchComicCreators(cParam)

    companion object {
        private lateinit var instance: ComicCategoryRepository

        fun getInstance(network: LyNetwork): ComicCategoryRepository {
            if (!Companion::instance.isInitialized) {
                synchronized(ComicCategoryRepository::class) {
                    if (!Companion::instance.isInitialized) {
                        instance =
                            ComicCategoryRepository(network)
                    }
                }
            }
            return instance
        }
    }
}