package com.indialone.youdizpracticaldemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.youdizpracticaldemo.model.CommentsResponse
import com.indialone.youdizpracticaldemo.model.PostResponse
import com.indialone.youdizpracticaldemo.repository.PostRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private val _response = MutableLiveData<List<PostResponse>>()
    private val _responseItem = MutableLiveData<PostResponse>()
    private val _commentsResponse = MutableLiveData<List<CommentsResponse>>()
    val response = _response
    val responseItem = _responseItem
    val commentsResponse = _commentsResponse

    fun fetchAllPosts() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val responseApi = async {
                        postRepository.getAllPosts()
                    }
                    _response.postValue(responseApi.await())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchPostById(id: String) {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val responseApi = async {
                        postRepository.getPostById(id)
                    }
                    _responseItem.postValue(responseApi.await())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchCommentsById(id: String) {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val responseApi = async {
                        postRepository.getCommentsById(id)
                    }
                    _commentsResponse.postValue(responseApi.await())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}