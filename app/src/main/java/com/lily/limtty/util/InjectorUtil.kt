package com.lily.limtty.util

import android.content.Context
import com.lily.limtty.db.GloableDatabase
import com.lily.limtty.net.LyNetwork
import com.lily.limtty.page.home.comic.ComicCategoryModelFactory
import com.lily.limtty.page.home.picture.PictureCategoryModelFactory
import com.lily.limtty.page.pic.pic_details.PictureDetailsModelFactory
import com.lily.limtty.repository.comic.ComicCategoryRepository
import com.lily.limtty.repository.picture.PictureDetailsRepository
import com.lily.limtty.repository.picture.PictureCategoryRepository

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.util
 *
 */
object InjectorUtil {

    private lateinit var context:Context

    fun init(context:Context){
        this.context=context
    }

    //获取分类Repository
    private fun getPictureCategoryRepository() =
        PictureCategoryRepository.getInstance(
            GloableDatabase.getCategoryDatabase(context),
            LyNetwork.getInstance()
        )

    //获取分类详情Repository
    private fun getPictureDetailsRepository()=
        PictureDetailsRepository.getInstance()

    //获取漫画Repository
    private fun getComicCategoryRepository()=ComicCategoryRepository.getInstance( LyNetwork.getInstance())

    fun getPictureCategoryModelFactory() = PictureCategoryModelFactory(getPictureCategoryRepository())

    fun getPictureDetailsModelFactory()=PictureDetailsModelFactory(getPictureDetailsRepository())

    fun getComicCategoryModelFactory()=ComicCategoryModelFactory(getComicCategoryRepository())
}