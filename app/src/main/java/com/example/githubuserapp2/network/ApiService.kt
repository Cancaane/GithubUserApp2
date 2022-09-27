package com.example.githubuserapp2.network

import com.example.githubuserapp2.response.SearchResponse
import com.example.githubuserapp2.response.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    fun searchUser(
        @Query("q")
        query : String
    ) : Call<SearchResponse>

    @GET("users/{username}")
    fun getDetailUser(
        @Path("username")
        username: String,
        @Header("Authorization")
        token : String = API_KEY
    ) : Call<User>

    @GET("users/{username}/followers")
    fun getFollowers(
        @Path("username")
        username: String,
        @Header("Authorization")
        token : String = API_KEY
    ) : Call<List<User>>

    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username")
        username: String,
        @Header("Authorization")
        token : String = API_KEY
    ) : Call<List<User>>

    companion object {
        private const val API_KEY = "token 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"
    }
}