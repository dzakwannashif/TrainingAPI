package com.dzakwan.pahlawanapp.ui.listuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dzakwan.pahlawanapp.data.UsersItem
import com.dzakwan.pahlawanapp.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUserViewModel : ViewModel() {

    // listUser ini digunakan sebagai penampung live data setelah diambil dari API
    private val listUser = MutableLiveData<List<UsersItem>>()

    fun getListUser() {
        ApiConfig.getAPIService().getListUsers().enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,

                // data sudah berada di parameter response ketika fungsi getListUser() dipakai
                response: Response<List<UsersItem>>
            ) {
                // mengisi listuser yang masih kosong dengan data response
                listUser.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }

    // fungsi yang bertugas untuk menyediakan data untuk di tampilkan/diobserve di UI Controller
    fun getResultListUser(): LiveData<List<UsersItem>> = listUser
}