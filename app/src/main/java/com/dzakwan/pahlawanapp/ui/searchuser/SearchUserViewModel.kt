package com.dzakwan.pahlawanapp.ui.searchuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dzakwan.pahlawanapp.data.UsersResponse
import com.dzakwan.pahlawanapp.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUserViewModel : ViewModel() {

    private val listUser = MutableLiveData<UsersResponse>()

    fun searchUser(userName: String) {
        ApiConfig.getAPIService().getSearchUser(userName).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                listUser.value = response.body()
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("SearchUser", "onFailure: $t", )
            }

        })
    }

    fun getSearchUser(): LiveData<UsersResponse> = listUser
}