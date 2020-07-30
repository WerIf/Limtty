package com.lily.limtty.page.home.comic

import com.lily.limlib.tools.BaseBindingAdapter
import com.lily.limtty.BR
import com.lily.limtty.LogTool
import com.lily.limtty.R
import com.lily.limtty.databinding.LayoutCategoryComicBinding
import com.lily.limtty.model.comic.Result

/**
 * Created by Werif
 * Created on 2020/7/30
 * PackageName com.lily.limtty.page.home.comic
 *
 */
class ComicAdapter:BaseBindingAdapter<Result,LayoutCategoryComicBinding>() {

    var index=0

    override fun getLayoutResId(viewType: Int): Int = R.layout.layout_category_comic

    override fun onBindItem(binding: LayoutCategoryComicBinding, item: Result) {

        LogTool.v(data = "  $index  thumbnail :${item.thumbnail}")
        index+=1
        binding.setVariable(BR.comicInfo,item)
    }
}