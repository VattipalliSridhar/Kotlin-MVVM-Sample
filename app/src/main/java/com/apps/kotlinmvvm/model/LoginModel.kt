package com.apps.kotlinmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginModel {
    @SerializedName("status_code")
    @Expose
    var statusCode: Int? = null

    @SerializedName("status_message")
    @Expose
    var statusMessage: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("user_id")
    @Expose
    var userId: String? = null

    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("ulbId")
    @Expose
    var ulbId: String? = null

    @SerializedName("user_type")
    @Expose
    var userType: String? = null

    @SerializedName("zone_id")
    @Expose
    var zoneId: Int? = null

    @SerializedName("circle_id")
    @Expose
    var circleId: String? = null

    @SerializedName("circle_name")
    @Expose
    var circleName: String? = null

    @SerializedName("circle_no")
    @Expose
    var circleNo: String? = null

    @SerializedName("ward_id")
    @Expose
    var wardId: Int? = null

    @SerializedName("csrf_token")
    @Expose
    var csrfToken: String? = null
}