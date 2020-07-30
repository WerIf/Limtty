package com.lily.limtty.db

import android.content.Context
import androidx.room.Room
import com.lily.limtty.db.picture.CategoryDao
import com.lily.limtty.db.picture.CategoryDataBase

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.db
 *
 */
object GloableDatabase {

    private lateinit var categoryDataBase:CategoryDataBase
    private lateinit var categoryDao:CategoryDao

    fun getCategoryDatabase(context:Context):CategoryDao=let {

        if(!::categoryDataBase.isInitialized || !::categoryDao.isInitialized){
            categoryDataBase= Room.databaseBuilder(context,CategoryDataBase::class.java,"category_database").allowMainThreadQueries().build()
            categoryDao= categoryDataBase.getCategoryDao()
        }

        categoryDao
    }



}