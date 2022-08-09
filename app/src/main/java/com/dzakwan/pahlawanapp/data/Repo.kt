package com.dzakwan.pahlawanapp.data

import android.content.ClipDescription
import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @field:SerializedName("items")
    val items: List<RepoItem>? = null
)

data class RepoItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("full_name")
    val fullName: String,

    @field:SerializedName("owner")
    val owner: OwnerItem,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("topics")
    val topics: List<String>
)

data class OwnerItem(
    @field:SerializedName("login")
    val login: String
)