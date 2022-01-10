package com.indialone.youdizpracticaldemo.api

import com.indialone.youdizpracticaldemo.model.CommentsResponse
import com.indialone.youdizpracticaldemo.model.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts")
    suspend fun getAllPosts(): List<PostResponse>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: String): PostResponse

    @GET("posts/{id}/comments")
    suspend fun getCommentsById(@Path("id") id: String): List<CommentsResponse>


}