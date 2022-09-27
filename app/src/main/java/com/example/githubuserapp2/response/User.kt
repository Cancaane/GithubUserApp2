package com.example.githubuserapp2.response

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("login")
	val username: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("company")
	val company: String,

	@field:SerializedName("location")
	val location: String,

	@field:SerializedName("public_repos")
	val repository: String,

	@field:SerializedName("followers")
	val followers: String,

	@field:SerializedName("following")
	val following: String,

	@field:SerializedName("avatar_url")
	val avatar: String
)
