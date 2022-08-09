package com.dzakwan.pahlawanapp.network

import com.dzakwan.pahlawanapp.data.RepoResponse
import com.dzakwan.pahlawanapp.data.UsersItem
import com.dzakwan.pahlawanapp.data.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getListUsers() : Call<List<UsersItem>>

    @GET("search/users")
    fun getSearchUser(
        @Query("q")
        username: String
    ) : Call<UsersResponse>

    @GET("search/repositories")
    fun getSearchRepo(@Query("q") repositories: String) : Call<RepoResponse>

}