package com.lily.myapplication.model.picture.new_classify

data class NWallPaperClassify(
    val consume: String,
    val `data`: List<Data>,
    val errmsg: String,
    val errno: String,
    val total: String
){
    override fun toString(): String {
        return "NWallPaperClassify(consume='$consume', `data`=$`data`, errmsg='$errmsg', errno='$errno', total='$total')"
    }
}