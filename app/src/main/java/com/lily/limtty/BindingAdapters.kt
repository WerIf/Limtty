package com.lily.limtty

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * Created by Werif
 * Created on 2020/7/23
 * PackageName com.lily.limtty
 *
 */
@BindingAdapter("bind:colorSchemeResources")
fun SwipeRefreshLayout.colorSchemeResources(resId: Int) {
    setColorSchemeResources(resId)
}