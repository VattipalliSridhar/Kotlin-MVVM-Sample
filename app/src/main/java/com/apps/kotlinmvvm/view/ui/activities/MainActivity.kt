package com.apps.kotlinmvvm.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.apps.kotlinmvvm.R
import com.apps.kotlinmvvm.view.baseclass.BaseActivity
import com.apps.kotlinmvvm.viewmodel.LoginViewModel

class MainActivity : BaseActivity() {

    private lateinit var  loginViewModel: LoginViewModel

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)






        if (isNetworkAvailable)
        {
            showDialog()


                loginViewModel!!.postLogin("testagency","testagency","1.0")

        }

        loginViewModel!!.loginLiveData?.observe(this, Observer {
            if(it.status_code==200)
            {
                Toast.makeText(applicationContext,"${it.username}",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"${it.status_message}",Toast.LENGTH_LONG).show()
            }
            dismissDialog()
        })


        loginViewModel.messageShow?.observe(this, Observer {

            showToastMessage(it)
        })





    }




}

