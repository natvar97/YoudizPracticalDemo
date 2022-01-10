package com.indialone.youdizpracticaldemo.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.youdizpracticaldemo.R
import com.indialone.youdizpracticaldemo.databinding.ActivityPostDetailsBinding
import com.indialone.youdizpracticaldemo.ui.adapters.RvCommentsAdapter
import com.indialone.youdizpracticaldemo.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class PostDetailsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityPostDetailsBinding
    private var id: Int? = null

    @Inject
    lateinit var postViewModel: PostViewModel

    private val adapter by lazy {
        RvCommentsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =
            DataBindingUtil.setContentView(this@PostDetailsActivity, R.layout.activity_post_details)

        if (intent.hasExtra("id")) {
            id = intent.getIntExtra("id", 0)
        }

        postViewModel.fetchPostById(id.toString())
        postViewModel.responseItem.observe(this) {
            mBinding.item = it
        }

        postViewModel.fetchCommentsById(id.toString())
        postViewModel.commentsResponse.observe(this) {
            mBinding.rvComments.layoutManager = LinearLayoutManager(this)
            adapter.addData(it)
            mBinding.rvComments.adapter = adapter
        }

    }
}