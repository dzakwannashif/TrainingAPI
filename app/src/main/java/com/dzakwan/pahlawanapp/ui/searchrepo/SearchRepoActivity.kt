package com.dzakwan.pahlawanapp.ui.searchrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakwan.pahlawanapp.data.RepoResponse
import com.dzakwan.pahlawanapp.databinding.ActivitySearchRepoBinding

class SearchRepoActivity : AppCompatActivity() {

    private var _binding : ActivitySearchRepoBinding? = null
    private val binding get() = _binding as ActivitySearchRepoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSearch = binding.btnSearch

        btnSearch.setOnClickListener {

            val searchRepo = binding.etSearch.text.toString()

            val viewModel = ViewModelProvider(this)[SearchRepoViewModel::class.java]

            viewModel.getRepo(searchRepo)
            viewModel.getListRepo().observe(this){
                Log.i("DataRepo", "Data Repo $it " +
                        "\n " +
                        "\n " +
                        "\n " +
                        "karena mensearch kata kunci dari --------> $searchRepo")
                showData(it)
            }

        }
    }

    private fun showData(data: RepoResponse) {
        val dataResults = data.items

        binding.apply {
            data.let {
                rvSearch.layoutManager = LinearLayoutManager(applicationContext)
                rvSearch.adapter = dataResults?.let { it1 -> SearchRepoAdapter(it1) }
            }
        }
    }
}