package com.lily.limtty.db.picture

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lily.limtty.model.classify.Category
import kotlin.collections.MutableList as MutableList1

/**
 * Created by Werif
 * Created on 2020/7/23
 * PackageName com.lily.limtty.db.picture
 *
 */
class CategoryBeanConverter {

    var gson = Gson()

    @TypeConverter
    fun categoryToSomeObjectList(data: String): List<Category> {

        var listType = TypeToken.get(Array<Category>::class.java).type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects:List<Category>):String{
        return gson.toJson(someObjects)
    }

}