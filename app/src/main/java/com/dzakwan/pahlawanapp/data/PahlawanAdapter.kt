package com.dzakwan.pahlawanapp.data

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzakwan.pahlawanapp.DetailActivity
import com.dzakwan.pahlawanapp.R
import com.dzakwan.pahlawanapp.databinding.RawRvHomeBinding
import com.dzakwan.pahlawanapp.utils.getJsonDataFromAsset
import com.google.gson.Gson

class PahlawanAdapter(val context: Context) :
    RecyclerView.Adapter<PahlawanAdapter.MyPahlawanHolder>() {

    private val pahlawanList: List<DaftarPahlawanItem> = Gson()
        .fromJson(
            getJsonDataFromAsset(context, "pahlawanNasional.json").toString(),
            DaftarPahlawan::class.java
        ).daftarPahlawan as List<DaftarPahlawanItem>

    inner class MyPahlawanHolder(val binding: RawRvHomeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyPahlawanHolder(
        RawRvHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyPahlawanHolder, position: Int) {
        val dataPahlawan = pahlawanList[position]
        holder.binding.apply {
            tvTitle.text = dataPahlawan.nama
            tvSubtitle.text = dataPahlawan.kategori
            tvRawAsal.text = dataPahlawan.asal
            tvRawUsia.text = dataPahlawan.usia

            Glide.with(imgRaw).load(dataPahlawan.img).placeholder(R.drawable.ic_refresh)
                .into(imgRaw)

            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DETAIL_KEY, dataPahlawan)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = pahlawanList.size
}