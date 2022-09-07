package com.dzakwan.pahlawanapp.ui.searchuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakwan.pahlawanapp.R
import com.dzakwan.pahlawanapp.data.UsersResponse
import com.dzakwan.pahlawanapp.databinding.ActivityListUserBinding
import com.dzakwan.pahlawanapp.databinding.ActivitySearchUserBinding
import okhttp3.internal.concurrent.formatDuration

class SearchUserActivity : AppCompatActivity() {

    private var _binding: ActivitySearchUserBinding? = null
    private val binding get() = _binding as ActivitySearchUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSearch = binding.btnSearch

        btnSearch.setOnClickListener {
            val searchName = binding.etSearch.text.toString()
            val viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]
            viewModel.searchUser(searchName)
            viewModel.getSearchUser().observe(this) {
                if(it == null){
                    Toast.makeText(this, "Hasil dengan nama $searchName, tidak ditemukan silahkan coba lagi", Toast.LENGTH_SHORT).show()
                }
                Log.i("DATA", "onCreate: $it " +
                        "\n " +
                        "\n " +
                        "\n " +
                        "Nama Usernya ------------------>${it.items?.get(0)?.login}<------------------")
                showData(it)
            }
        }
    }

    private fun showData(data: UsersResponse) {
        val dataResults = data.items
        binding.apply {
            data.let {
                rvSearch.layoutManager = LinearLayoutManager(applicationContext)
                rvSearch.adapter = dataResults?.let { it -> SearchUserAdapter(it) }
            }
        }
    }
}