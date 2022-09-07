package com.dzakwan.pahlawanapp.ui.listuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakwan.pahlawanapp.R
import com.dzakwan.pahlawanapp.data.UsersItem
import com.dzakwan.pahlawanapp.databinding.ActivityListUserBinding

class ListUserActivity : AppCompatActivity() {

    private var _binding: ActivityListUserBinding? = null
    private val binding get() = _binding as ActivityListUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[ListUserViewModel::class.java]
        /**
         * Second Move
         * val viewModel = ViewModelProvider(this).get(ListUserViewModel::class.java)
         */
        viewModel.getListUser()
        viewModel.getResultListUser().observe(this){
            Log.i("ListUser", "onCreate: $it")
            showData(it)
        }
    }

    private fun showData(data: List<UsersItem>) {
        binding.apply {
            data.let {
                rvList.layoutManager = LinearLayoutManager(applicationContext)
                rvList.adapter = ListUserAdapter(data)
            }
        }
    }
}