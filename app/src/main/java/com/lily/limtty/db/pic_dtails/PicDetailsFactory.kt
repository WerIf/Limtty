package com.lily.limtty.db.pic_dtails

import androidx.paging.DataSource
import com.lily.limtty.model.pic_details.Vertical

/**
 * Created by Werif
 * Created on 2020/7/29
 * PackageName com.lily.limtty.db.pic_dtails
 *
 */
class PicDetailsFactory(var pId:String):DataSource.Factory<Int, Vertical>() {
    override fun create()=PicDetailsResource(pId)
}