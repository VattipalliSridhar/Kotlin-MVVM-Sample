package com.apps.kotlinmvvm.repository

import com.apps.kotlinmvvm.model.LoginModelNew
import com.apps.kotlinmvvm.view.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository : SafeApiRequest() {
   suspend fun getLoginData(userName: String, passWord: String, apk: String): Response<LoginModelNew>? {
       return withContext(Dispatchers.IO) {
           RetrofitClient.apiInterface.login(userName, passWord, apk)
       }
    }
}

