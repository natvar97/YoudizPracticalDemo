package com.indialone.youdizpracticaldemo.model

import com.google.gson.annotations.SerializedName

data class CommentsResponse(
    @SerializedName("body")
    var body: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("postId")
    var postId: Int? = 0,
)