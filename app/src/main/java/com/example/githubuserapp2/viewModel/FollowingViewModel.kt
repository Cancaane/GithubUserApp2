package com.example.githubuserapp2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubuserapp2.Resource
import com.example.githubuserapp2.network.ApiConfig
import com.example.githubuserapp2.response.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingViewModel: ViewModel() {

    private val config = ApiConfig.getApiService()
    private val user = MutableLiveData<Resource<List<User>>>()

    fun getFollowing(username: String) : LiveData<Resource<List<User>>> {
        user.postValue(Resource.Loading())
        config.getFollowing(username).enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val result = response.body()
                user.postValue(Resource.Success(result))
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                user.postValue(Resource.Error(t.message))
            }
        })

        return user
    }
}