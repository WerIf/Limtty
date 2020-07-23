package com.lily.myapplication.model.picture.new_pic

data class NPicture(
    val consume: String,
    val `data`: List<Data>,
    val errmsg: String,
    val errno: String,
    val total: String
)