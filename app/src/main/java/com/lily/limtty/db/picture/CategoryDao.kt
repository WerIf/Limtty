package com.lily.limtty.db.picture

import androidx.room.*
import com.lily.limtty.model.classify.Category

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

    @Delete
    fun deleteAll(category:ArrayList<Category>):Int

    @Update
    fun update(category:Category):Int

    @Query("SELECT * FROM CATEGORY")
    fun findCategoryById():List<Category>?
}