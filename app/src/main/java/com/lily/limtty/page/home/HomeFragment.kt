package com.lily.limtty.page.home

import android.view.View
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.lily.limlib.root.LRootFragment
import com.lily.limlib.root.LVPagerAdapter
import com.lily.limtty.R
import com.lily.limtty.databinding.FragmentHomeBinding
import com.lily.limtty.databinding.LayoutCollectViewBinding
import com.lily.limtty.databinding.LayoutPageViewBinding
import com.lily.limtty.databinding.LayoutShareViewBinding
import com.lily.limtty.page.home.view.CollectionView
import com.lily.limtty.page.home.view.PageView
import com.lily.limtty.page.home.view.ShareView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limtty.page.home
 *
 */
class HomeFragment:LRootFragment<FragmentHomeBinding>() {

    private var viewList= mutableListOf<View>()

    override fun getContentId(): Int = R.layout.fragment_home

    override fun initOperation() {
        super.initOperation()
        fController.navigate(R.id.action_homeFragment_to_loginFragment)
    }

    override fun initL() {

        var pageBinding=PageView.instance<LayoutPageViewBinding>().createBinding(requireContext())
        var collectBinding= CollectionView.instance<LayoutCollectViewBinding>().createBinding(requireContext())
        var shareBinding= ShareView.instance<LayoutShareViewBinding>().createBinding(requireContext())

        viewList.add(pageBinding.root)
        viewList.add(collectBinding.root)
        viewList.add(shareBinding.root)

        //加载页面
        initPage()
    }

    override fun initE() {

        //viewPager 滑动监听
        homeRootPage.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
//                homeRootBottom.menu.getItem(position).isChecked=true
                when(position){
                    0->{
                        homeRootBottom.selectedItemId=R.id.windmill
                    }
                    1->{
                        homeRootBottom.selectedItemId=R.id.hope
                    }
                    2->{
                        homeRootBottom.selectedItemId=R.id.canvas
                    }
                }
            }

        })

        homeRootBottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.windmill->{
                    homeRootPage.currentItem=0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.hope->{
                    homeRootPage.currentItem=1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.canvas->{
                    homeRootPage.currentItem=2
                    return@setOnNavigationItemSelectedListener true
                }

            }
            return@setOnNavigationItemSelectedListener false
        }
    }


    private fun initPage(){
        var viewPager=LVPagerAdapter(viewList)
        homeRootPage.adapter=viewPager
        //设置ViewPager页面最大缓存数
        homeRootPage.offscreenPageLimit=3
    }
}