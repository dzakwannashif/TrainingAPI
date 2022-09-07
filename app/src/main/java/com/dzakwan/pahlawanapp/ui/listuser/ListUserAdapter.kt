package com.dzakwan.pahlawanapp.ui.listuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzakwan.pahlawanapp.R
import com.dzakwan.pahlawanapp.data.UsersItem
import com.dzakwan.pahlawanapp.databinding.RawListUserBinding

class ListUserAdapter(private val listUser: List<UsersItem>) :
    RecyclerView.Adapter<ListUserAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RawListUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        RawListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val dataUser = listUser[position]
        holder.binding.apply {
            Glide.with(imgList)
                .load(dataUser.avatarUrl)
                .placeholder(R.drawable.ic_refresh)
                .into(imgList)

            tvLogin.text = dataUser.login
        }
    }

    override fun getItemCount(): Int = listUser.size
}