package com.dzakwan.pahlawanapp.ui.searchuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.dzakwan.pahlawanapp.R

class SearchUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user)

        val searchName = "Sarah"

        val viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]

        viewModel.searchUser(searchName)
        viewModel.getSearchUser().observe(this) {
            Log.i("DATA", "onCreate: $it " +
                    "\n " +
                    "\n " +
                    "\n " +
                    "Nama Usernya ------------------>${it.items?.get(0)?.login}<------------------")
            println(it.items?.get(0)?.login)
        }
    }
}