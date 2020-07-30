package com.lily.limtty.db.picture

import androidx.room.*
import com.lily.limtty.model.pic_category.Category

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.db
 *
 */
@Dao
interface CategoryDao {
    @Insert
    fun insert(category:Category)

    @Update
    fun update(vararg category: Category):Int

    @Query("SELECT * FROM CATEGORY")
    fun findCategoryById():List<Category>?
}