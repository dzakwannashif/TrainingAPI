package com.dzakwan.pahlawanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dzakwan.pahlawanapp.databinding.ActivityMainBinding
import com.dzakwan.pahlawanapp.ui.listuser.ListUserActivity
import com.dzakwan.pahlawanapp.ui.searchrepo.SearchRepoActivity
import com.dzakwan.pahlawanapp.ui.searchuser.SearchUserActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnRvJson.setOnClickListener(this@MainActivity)
            btnRvListUser.setOnClickListener(this@MainActivity)
            btnRvSearchUser.setOnClickListener(this@MainActivity)
            btnRvRepo.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_rv_json -> startActivity(Intent(this, JsonActivity::class.java))
            R.id.btn_rv_list_user -> startActivity(Intent(this, ListUserActivity::class.java))
            R.id.btn_rv_repo -> startActivity(Intent(this, SearchRepoActivity::class.java))
            R.id.btn_rv_search_user -> startActivity(Intent(this, SearchUserActivity::class.java))
        }
    }
}