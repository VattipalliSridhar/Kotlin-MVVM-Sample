package com.apps.kotlinmvvm.repository

import com.apps.kotlinmvvm.model.UserLogin
import com.apps.kotlinmvvm.model.UserLoginModel
import com.apps.kotlinmvvm.model.UserResponseModel
import com.apps.kotlinmvvm.view.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response


class UserRepository {


    suspend fun getLoginData(userData: UserLogin): Call<UserLogin?>? {
        return withContext(Dispatchers.IO) {
            RetrofitClient.apiInterface.getUserData(userData)
        }
    }

    /* suspend fun getLoginData(userData: UserLoginModel): Call<UserResponseModel> {

         return withContext(Dispatchers.IO) {
             RetrofitClient.apiInterface.getUser(userData.toString())
         }

     }*/

    /*suspend fun getLoginData(userData: UserLoginModel): Call<UserResponseModel> {
        return withContext(Dispatchers.IO) {
            RetrofitClient.apiInterface.getUser(userData.toString())
        }

    }*/


}