package com.indialone.youdizpracticaldemo.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.indialone.youdizpracticaldemo.R
import com.indialone.youdizpracticaldemo.databinding.ActivityLoginBinding
import com.indialone.youdizpracticaldemo.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLoginBinding

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        mBinding.viewmodel = loginViewModel

        loginViewModel.isValid.observe(this) {
            if (it) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

    }
}