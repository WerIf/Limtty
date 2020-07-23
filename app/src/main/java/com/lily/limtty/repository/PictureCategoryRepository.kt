package com.lily.limtty.repository

import android.util.Log
import com.lily.limtty.LogTool
import com.lily.limtty.db.picture.CategoryDao
import com.lily.limtty.model.classify.Category
import com.lily.limtty.net.LyNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Werif
 * Created on 2020/7/22
 * PackageName com.lily.limtty.repository
 *
 */
class PictureCategoryRepository private constructor(private val categoryDao: CategoryDao, private val network:LyNetwork){

    suspend fun getCategory():MutableList<Category>{
        var categoryList=categoryDao.findCategoryById()
        LogTool.v(data = "from database  ${categoryList?.size}")

        if(categoryList?.size==0)categoryList=requestCategory()
        return categoryList!!.toMutableList()
    }

    suspend fun refreshCategory()=requestCategory()


    private suspend fun requestCategory()= withContext(Dispatchers.IO){
        var heCategory=network.fetchPictureClassifyList()
        val category=heCategory.res.category
        category.forEach {
            categoryDao.insert(it)
        }
        category
    }

    companion object{

        private lateinit var instance:PictureCategoryRepository

        fun getInstance(categoryDao: CategoryDao, network: LyNetwork):PictureCategoryRepository{
            if(!::instance.isInitialized){
                synchronized(PictureCategoryRepository::class){
                    if(!::instance.isInitialized){
                        instance=PictureCategoryRepository(categoryDao,network)
                    }
                }
            }
            return instance
        }
    }
}