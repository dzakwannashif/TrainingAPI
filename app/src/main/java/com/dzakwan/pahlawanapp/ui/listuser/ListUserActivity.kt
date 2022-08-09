package com.dzakwan.pahlawanapp.ui.listuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.dzakwan.pahlawanapp.R

class ListUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        val viewModel = ViewModelProvider(this)[ListUserViewModel::class.java]
        /**
         * Second Move
         * val viewModel = ViewModelProvider(this).get(ListUserViewModel::class.java)
         */
        viewModel.getListUser()
        viewModel.getResultListUser().observe(this){
            Log.i("ListUser", "onCreate: $it")
        }
    }
}