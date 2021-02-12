package com.apps.kotlinmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.kotlinmvvm.model.LoginModelNew
import com.apps.kotlinmvvm.repository.LoginRepository
import kotlinx.coroutines.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private val loginRepository: LoginRepository = LoginRepository()
    private lateinit var response : Response<LoginModelNew>
    var loginLiveData: MutableLiveData<LoginModelNew>? = MutableLiveData<LoginModelNew>()
    var messageShow : MutableLiveData<String>? = MutableLiveData<String>()

      fun postLogin(userName: String, passWord: String, apk: String) =
        viewModelScope.launch {
           // loginLiveData?.value = loginRepository.getLoginData(userName, passWord, apk)
           response= loginRepository.getLoginData(userName, passWord, apk)!!
            if(response.isSuccessful)
            {
                loginLiveData?.value = response.body()
            }else{

                val error = response.errorBody()?.string()
                val message = StringBuilder()
                error?.let{
                    try{
                        message.append(JSONObject(it).getString("message"))
                    }catch(e: JSONException){ }
                    message.append("\n")
                }
                message.append("Error Code: ${response.code()}")

                messageShow?.value = message.toString()
            }
        }

}

