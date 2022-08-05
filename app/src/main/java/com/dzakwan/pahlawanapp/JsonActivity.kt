package com.dzakwan.pahlawanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzakwan.pahlawanapp.data.PahlawanAdapter
import com.dzakwan.pahlawanapp.databinding.ActivityJsonBinding

class JsonActivity : AppCompatActivity() {

    private var _binding : ActivityJsonBinding? = null
    private val binding get() = _binding as ActivityJsonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Pahlawan Indonesia"
        supportActionBar?.elevation = 15F

        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(this@JsonActivity)
            adapter = PahlawanAdapter(this@JsonActivity)
        }
    }
}