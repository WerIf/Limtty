package com.lily.limtty.util

import android.content.Context
import com.lily.limtty.db.GloableDatabase
import com.lily.limtty.net.LyNetwork
import com.lily.limtty.page.home.picture.PictureCategoryModelFactory
import com.lily.limtty.repository.PictureCategoryRepository

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

    private fun getPictureCategoryRepository() =
        PictureCategoryRepository.getInstance(
            GloableDatabase.getCategoryDatabase(context),
            LyNetwork.getInstance()
        )

    fun getPictureCategoryModelFactory() = PictureCategoryModelFactory(getPictureCategoryRepository())
}