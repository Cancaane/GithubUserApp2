package com.example.githubuserapp2.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(

	@field:SerializedName("items")
	val items: List<User>
)
