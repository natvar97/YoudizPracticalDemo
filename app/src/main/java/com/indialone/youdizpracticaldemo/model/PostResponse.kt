package com.indialone.youdizpracticaldemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("userId")
    var userId: Int? = 0,


    @SerializedName("body")
    var body: String? = null,


    @SerializedName("title")
    var title: String? = null,


    @SerializedName("id")
    var id: Int? = 0
)