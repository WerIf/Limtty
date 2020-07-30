package com.lily.limtty.page.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.lily.limlib.root.LRootFragment
import com.lily.limlib.root.LVPagerAdapter
import com.lily.limtty.R
import com.lily.limtty.databinding.FragmentHomeBinding
import com.lily.limtty.databinding.LayoutCollectViewBinding
import com.lily.limtty.databinding.LayoutPageViewBinding
import com.lily.limtty.databinding.LayoutShareViewBinding
import com.lily.limtty.page.home.comic.ComicAdapter
import com.lily.limtty.page.home.comic.ComicCategoryViewModel
import com.lily.limtty.page.home.comic.ComicView
import com.lily.limtty.page.home.picture.PictureAdapter
import com.lily.limtty.page.home.picture.PictureView
import com.lily.limtty.page.home.picture.PictureViewModel
import com.lily.limtty.util.InjectorUtil
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limtty.page.home
 *
 */
class HomeFragment : LRootFragment<FragmentHomeBinding>() {

    private var viewList = mutableListOf<View>()

    lateinit var pageBinding: LayoutPageViewBinding
    lateinit var collectBinding: LayoutCollectViewBinding
    lateinit var shareBinding: LayoutShareViewBinding

    private val pictureModel by lazy {
        ViewModelProvider(
            this,
            InjectorUtil.getPictureCategoryModelFactory()
        ).get(PictureViewModel::class.java)
    }

    private val comicModel by lazy {
        ViewModelProvider(this, InjectorUtil.getComicCategoryModelFactory()).get(
            ComicCategoryViewModel::class.java
        )
    }

    override fun getContentId(): Int = R.layout.fragment_home

    override fun initOperation() {
        super.initOperation()
        fController.navigate(R.id.action_homeFragment_to_loginFragment)
    }

    override fun initL() {

        pageBinding =
            PictureView.instance<LayoutPageViewBinding>().createBinding(requireContext())
        collectBinding =
            ComicView.instance<LayoutCollectViewBinding>().createBinding(requireContext())
        shareBinding = ShareView.instance<LayoutShareViewBinding>().createBinding(requireContext())

        viewList.add(pageBinding.root)
        viewList.add(collectBinding.root)
        viewList.add(shareBinding.root)

        //加载页面
        initPage()

        //加载分类
        initCategory()
    }

    override fun initE() {


        //viewPager 滑动监听
        homeRootPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        homeRootBottom.selectedItemId = R.id.windmill
                    }
                    1 -> {
                        homeRootBottom.selectedItemId = R.id.hope
                        //加载Marvel
                        initComic()
                    }
                    2 -> {
                        homeRootBottom.selectedItemId = R.id.canvas
                    }
                }
            }

        })

        homeRootBottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.windmill -> {
                    homeRootPage.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.hope -> {
                    homeRootPage.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.canvas -> {
                    homeRootPage.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }

            }
            return@setOnNavigationItemSelectedListener false
        }
    }


    private fun initPage() {
        var viewPager = LVPagerAdapter(viewList)
        homeRootPage.adapter = viewPager
        //设置ViewPager页面最大缓存数
        homeRootPage.offscreenPageLimit = 3
    }

    private fun initCategory() {
        pageBinding.viewModel = pictureModel
        pageBinding.resId = R.color.theme_color
        pageBinding.lifecycleOwner = this

        var pictureAdapter = PictureAdapter()
        pageBinding.categoryList.adapter = pictureAdapter

        var layoutManager =
            GridLayoutManager(context, 2)

        pageBinding.categoryList.layoutManager = layoutManager
        pictureAdapter.initClickEvent { index, data ->
            var bundle = Bundle()
            bundle.putString("categoryId", data.id)
            bundle.putString("categoryName", data.name)
            fController.navigate(R.id.action_homeFragment_to_picDetailsFragment, bundle)
        }

        //数据绑定UI
        pictureModel.categoryList.observe(this, Observer {
            //需要进行数据的加载和刷新
            if (pictureAdapter.items.size > 0) {
                pictureAdapter.items.clear()
            }
            pictureAdapter.items.addAll(it)
        })


        //加载数据
        pictureModel.getCategory()
    }

    private fun initComic(){
        comicModel.requestComicCreators()
//        var comicAdapter=ComicAdapter()
//        collectBinding.lifecycleOwner=this
//        collectBinding.comicList.adapter=comicAdapter
//        var layoutManager =
//            GridLayoutManager(context, 2)
//
//        collectBinding.comicList.layoutManager = layoutManager
//        comicModel.requestComicCategory{
//            comicAdapter.items.addAll(it.data.results)
//        }
    }
}