package com.apps.kotlinmvvm.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.apps.kotlinmvvm.R
import com.apps.kotlinmvvm.model.UserLogin
import com.apps.kotlinmvvm.model.UserLoginModel
import com.apps.kotlinmvvm.view.baseclass.BaseActivity
import com.apps.kotlinmvvm.viewmodel.LoginViewModel
import com.apps.kotlinmvvm.viewmodel.UserLoginViewModel

class UserLogin : BaseActivity() {
    private lateinit var userLoginViewModel: UserLoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        userLoginViewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)



        if (isNetworkAvailable)
        {
            //showDialog()
            val userData = UserLogin("epdcl","1071558","5.4")
            userLoginViewModel.postLogin(userData)

        }


    }
}