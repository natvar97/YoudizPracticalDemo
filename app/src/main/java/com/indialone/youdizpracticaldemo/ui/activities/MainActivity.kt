package com.indialone.youdizpracticaldemo.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.youdizpracticaldemo.R
import com.indialone.youdizpracticaldemo.databinding.ActivityMainBinding
import com.indialone.youdizpracticaldemo.model.PostResponse
import com.indialone.youdizpracticaldemo.ui.adapters.RvPostAdapter
import com.indialone.youdizpracticaldemo.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RvPostAdapter.ClickListener {

    private lateinit var mBinding: ActivityMainBinding

    @Inject
    lateinit var postViewModel: PostViewModel

    private val adapter by lazy {
        RvPostAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        postViewModel.fetchAllPosts()
        postViewModel.response.observe(this) {
            mBinding.rvPosts.layoutManager = LinearLayoutManager(this)
            adapter.addData(it)
            mBinding.rvPosts.adapter = adapter
        }


    }

    override fun onClick(position: Int, data: PostResponse) {
        val intent = Intent(this, PostDetailsActivity::class.java)
        intent.putExtra("id", data.id)
        startActivity(intent)
    }
}