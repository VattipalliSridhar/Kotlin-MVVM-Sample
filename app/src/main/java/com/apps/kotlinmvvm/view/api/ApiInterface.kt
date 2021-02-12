package com.apps.kotlinmvvm.view.api

import com.apps.kotlinmvvm.model.LoginModelNew
import com.apps.kotlinmvvm.view.baseclass.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {


    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("username") user: String,
        @Field("password") password: String,
        @Field("apk_version") apk: String
    ): Response<LoginModelNew>


    companion object{
        operator fun invoke() {

            val levelType: HttpLoggingInterceptor.Level =
                HttpLoggingInterceptor.Level.BODY

            val logging = HttpLoggingInterceptor()
            logging.setLevel(levelType)

            val okkHttpclient = OkHttpClient.Builder()
            okkHttpclient.addInterceptor(logging)

            Retrofit.Builder()
                .baseUrl(Constants.Base_Url)
                .client(okkHttpclient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }

}
