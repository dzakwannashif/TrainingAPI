package com.dzakwan.pahlawanapp.ui.searchrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzakwan.pahlawanapp.R
import com.dzakwan.pahlawanapp.data.RepoItem
import com.dzakwan.pahlawanapp.databinding.ActivitySearchUserBinding
import com.dzakwan.pahlawanapp.databinding.RawRepoBinding

class SearchRepoAdapter(val listRepo: List<RepoItem>) : RecyclerView.Adapter<SearchRepoAdapter.RepoViewHolder>() {

    inner class RepoViewHolder(val binding: RawRepoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RepoViewHolder(
        RawRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val dataRepo = listRepo[position]

        holder.binding.apply {
            Glide.with(imgRepo).load(dataRepo.owner.avatarUrl).placeholder(R.drawable.ic_refresh).into(imgRepo)

            tvLogin.text = dataRepo.owner.login
            tvDesc.text = dataRepo.description
            tvFullname.text = dataRepo.fullName
        }
    }

    override fun getItemCount(): Int = listRepo.size
}