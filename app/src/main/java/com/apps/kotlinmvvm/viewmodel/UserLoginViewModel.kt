package com.apps.kotlinmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.kotlinmvvm.model.LoginModelNew
import com.apps.kotlinmvvm.model.UserLogin
import com.apps.kotlinmvvm.model.UserLoginModel
import com.apps.kotlinmvvm.model.UserResponseModel
import com.apps.kotlinmvvm.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class UserLoginViewModel : ViewModel() {
    var loginLiveData: MutableLiveData<UserLogin>? = MutableLiveData<UserLogin>()
    private val loginRepository: UserRepository = UserRepository()
    private lateinit var response : Call<UserLogin>
    fun postLogin(userData: UserLogin) {
        viewModelScope.launch {
           loginRepository.getLoginData(userData)

        }

    }


}

