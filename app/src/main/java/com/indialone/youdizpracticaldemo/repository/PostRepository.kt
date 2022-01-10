package com.indialone.youdizpracticaldemo.repository

import androidx.annotation.WorkerThread
import com.indialone.youdizpracticaldemo.api.ApiService
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {

    @WorkerThread
    suspend fun getAllPosts() = apiService.getAllPosts()

    @WorkerThread
    suspend fun getPostById(id: String) = apiService.getPostById(id)

    @WorkerThread
    suspend fun getCommentsById(id: String) = apiService.getCommentsById(id)

}