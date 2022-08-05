package com.dzakwan.pahlawanapp.network

import com.dzakwan.pahlawanapp.data.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getListUsers() : Call<List<UsersItem>>


}