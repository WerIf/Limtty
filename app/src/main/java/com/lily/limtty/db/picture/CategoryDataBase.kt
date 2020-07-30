package com.lily.limtty.db.picture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lily.limtty.model.pic_category.Category

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.db.picture
 *
 */
@Database(entities = [Category::class],version = 1,exportSchema = false)
abstract class CategoryDataBase:RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
}