package com.lily.limtty.model.pic_category

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @NonNull
    @PrimaryKey
    val id: String,
    val atime: Double,
    val count: Int,
    val cover: String,
    val cover_temp: String,
    val ename: String,
    val icover: String,
    val name: String,
    val picasso_cover: String,
    val rank: Int,
    val rname: String,
    val sn: Int,
    val type: Int
){

}