package com.dzakwan.pahlawanapp.ui.searchrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.dzakwan.pahlawanapp.R

class SearchRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_repo)

        val searchRepo = "weather app"

        val viewModel = ViewModelProvider(this)[SearchRepoViewModel::class.java]

        viewModel.getRepo(searchRepo)
        viewModel.getListRepo().observe(this){
            Log.i("DataRepo", "Data Repo $it " +
                    "\n " +
                    "\n " +
                    "\n " +
                    "karena mensearch kata kunci dari --------> $searchRepo")
        }
    }
}