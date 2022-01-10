package com.indialone.youdizpracticaldemo.viewmodel

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(context: Context) : ViewModel() {

    var username = ObservableField<String>()
    var password = ObservableField<String>()

    private var appContext: Context? = null

    init {
        appContext = context
    }

    val isValid = MutableLiveData<Boolean>()


    private fun isValidEntry(): Boolean {
        return when {
            TextUtils.isEmpty((username.get() ?: "").toString().trim { it <= ' ' }) -> {
                Toast.makeText(appContext, "Phone number should not be empty", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            username.get().toString().trim { it <= ' ' }.length != 10 -> {
                Toast.makeText(appContext, "Phone number should of 10 digits", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            TextUtils.isEmpty((password.get() ?: "").toString().trim { it <= ' ' }) -> {
                Toast.makeText(appContext, "Password should not be empty", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            password.get().toString().trim { it <= ' ' }.length < 5 -> {
                Toast.makeText(appContext, "Password should be greater than 5 characters", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            else -> {
                true
            }
        }
    }

    fun goToNextScreen() {
        isValid.value = isValidEntry()
    }

}

