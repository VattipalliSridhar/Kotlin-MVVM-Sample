package com.apps.kotlinmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserLogin(
    @field:Expose @field:SerializedName("USER_ID") var uSERID: String,
    @field:Expose @field:SerializedName(
        "PASSWORD"
    ) var pASSWORD: String,
    @field:Expose @field:SerializedName("VERSION") var vERSION: String

    
)