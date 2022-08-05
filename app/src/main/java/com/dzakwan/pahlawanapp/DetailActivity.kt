package com.dzakwan.pahlawanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dzakwan.pahlawanapp.data.DaftarPahlawan
import com.dzakwan.pahlawanapp.data.DaftarPahlawanItem
import com.dzakwan.pahlawanapp.databinding.ActivityDetailBinding
import com.dzakwan.pahlawanapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private var _binding : ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail"

        val data = intent.getParcelableExtra<DaftarPahlawan>(DETAIL_KEY) as DaftarPahlawanItem
        Glide.with(this).load(data.img).into(binding.imgDetail)

        binding.apply {
            tvNama1.text = data.nama
            tvAsal.text = data.asal
            tvGugur.text = data.gugur
            tvHistory.text = data.history
            tvKategori.text = data.kategori
            tvNama2.text = data.nama2
            tvLokasiMakam.text = data.lokasimakam
            tvLahir.text = data.lahir
            tvUsia.text = data.usia
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        val DETAIL_KEY = "detail_key"
    }
}
