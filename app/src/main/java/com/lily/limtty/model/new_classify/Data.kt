package com.lily.myapplication.model.picture.new_classify

data class Data(
    val create_time: String,
    val displaytype: String,
    val id: String,
    val name: String,
    val tempdata: String,
    val totalcnt: String
){
    override fun toString(): String {
        return "Data(create_time='$create_time', displaytype='$displaytype', id='$id', name='$name', tempdata='$tempdata', totalcnt='$totalcnt')"
    }
}