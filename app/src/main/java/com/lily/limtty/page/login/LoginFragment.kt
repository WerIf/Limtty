package com.lily.limtty.page.login

import androidx.core.content.ContextCompat
import com.lily.limlib.root.LRootFragment
import com.lily.limlib.snackbar.LSnackBar
import com.lily.limtty.R
import com.lily.limtty.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by Werif
 * Created on 2020/6/28
 * PackageName com.lily.limtty.page
 *
 */
class LoginFragment:LRootFragment<FragmentLoginBinding>() {
    override fun getContentId(): Int = R.layout.fragment_login

    override fun initL() {
    }

    override fun initE() {

        clickLogin.setOnClickListener {
            val text=login_user_psd.editText?.text?.toString()
            if(text.isNullOrBlank()){
                login_user_psd.error=requireContext().resources.getString(R.string.hint_password)
                return@setOnClickListener
            }

//            LSnackBar.mack(it,"登录成功",0)
            fController.popBackStack()
        }
    }
}