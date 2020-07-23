package com.lily.limtty.model.classify

import android.view.View
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) val cid:Int=0,
    val atime: Double,
    val count: Int,
    val cover: String,
    val cover_temp: String,
    val ename: String,
    val icover: String,
    @ColumnInfo(name = "ctId")
    val id: String,
    val name: String,
    val picasso_cover: String,
    val rank: Int,
    val rname: String,
    val sn: Int,
    val type: Int
){

}