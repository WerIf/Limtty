package com.lily.limtty.page.pic

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lily.limlib.root.LRootFragment
import com.lily.limtty.R
import com.lily.limtty.databinding.FragmentPictureDetailsBinding
import com.lily.limtty.page.pic.pic_details.PicDetailsViewModel
import com.lily.limtty.page.pic.pic_details.PictureDetailsAdapter
import com.lily.limtty.util.InjectorUtil
import kotlinx.android.synthetic.main.fragment_picture_details.*

/**
 * Created by Werif
 * Created on 2020/7/28
 * PackageName com.lily.limtty.page.pic
 *
 */
class PicDetailsFragment: LRootFragment<FragmentPictureDetailsBinding>() {

    private val categoryId by lazy {
        requireArguments().getString("categoryId")
    }

    private val categoryName by lazy {
        requireArguments().getString("categoryName")
    }

    private val picDetailsModel by lazy {
        ViewModelProvider(this,InjectorUtil.getPictureDetailsModelFactory()).get(PicDetailsViewModel::class.java)
    }

    override fun getContentId(): Int = R.layout.fragment_picture_details

    override fun initL() {

        categoryName?.run {
            picDetailsBar.title=this
        }

        var pidAdapter= PictureDetailsAdapter()
        detImageList.adapter=pidAdapter
        detImageList.layoutManager=GridLayoutManager(requireContext(),2)
//        picDetailsModel.dataList.observe(this, Observer {
//
//        })

        categoryId?.let {
            cId->
            picDetailsModel.getPidDetails(cId).observe(this, Observer {
                pidAdapter.submitList(it)
            })
        }
    }

    override fun initE() {

        initToolBarEvent(picDetailsBar)
    }
}