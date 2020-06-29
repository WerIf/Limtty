package com.lily.limlib.root

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

/**
 * Created by Werif
 * Created on 2020/6/29
 * PackageName com.lily.limlib.root
 *
 */
class LVPagerAdapter(var lView:MutableList<View>, var lTitle:MutableList<String>?=null):PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean =view==`object`

    override fun getCount(): Int =lView.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        container.removeView(lView[position])
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(lView[position])
        return lView[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {

        if(!lTitle.isNullOrEmpty()){
            return lTitle!![position]
        }
        return super.getPageTitle(position)
    }
}