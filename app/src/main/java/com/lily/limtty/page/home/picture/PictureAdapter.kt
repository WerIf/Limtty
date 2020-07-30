package com.lily.limtty.page.home.picture

import com.lily.limlib.tools.BaseBindingAdapter
import com.lily.limtty.BR
import com.lily.limtty.R
import com.lily.limtty.databinding.LayoutCategoryImageBinding
import com.lily.limtty.model.pic_category.Category

/**
 * Created by Werif
 * Created on 2020/7/27
 * PackageName com.lily.limtty.page.home.picture
 *
 */
class PictureAdapter():BaseBindingAdapter<Category,LayoutCategoryImageBinding>() {

    override fun getLayoutResId(viewType: Int) = R.layout.layout_category_image

    override fun onBindItem(binding: LayoutCategoryImageBinding, item: Category) {
        binding.setVariable(BR.categoryInfo,item)
    }
}