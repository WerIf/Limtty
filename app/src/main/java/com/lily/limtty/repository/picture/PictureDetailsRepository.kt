package com.lily.limtty.repository.picture

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.lily.limtty.db.pic_dtails.PicDetailsFactory

/**
 * Created by Werif
 * Created on 2020/7/28
 * PackageName com.lily.limtty.repository
 *
 */
class PictureDetailsRepository private constructor() {

    fun getPicDetails(pId:String) = LivePagedListBuilder(
        PicDetailsFactory(pId),
        PagedList.Config.Builder()
            .setPageSize(30)
            .setPrefetchDistance(30)
            .setEnablePlaceholders(false)
            .build()
    ).build()



    companion object {
        private lateinit var instance: PictureDetailsRepository

        fun getInstance(): PictureDetailsRepository {
            if (!Companion::instance.isInitialized) {
                synchronized(PictureDetailsRepository::class) {
                    if (!Companion::instance.isInitialized) {
                        instance =
                            PictureDetailsRepository()
                    }
                }
            }
            return instance
        }
    }
}