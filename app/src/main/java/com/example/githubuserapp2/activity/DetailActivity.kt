package com.example.githubuserapp2.activity

import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubuserapp2.R
import com.example.githubuserapp2.Resource
import com.example.githubuserapp2.databinding.ActivityDetailBinding
import com.example.githubuserapp2.response.User
import com.example.githubuserapp2.viewModel.DetailViewModel

class DetailActivity : AppCompatActivity() {

//    @StringRes
//    val TAB_TITLES = intArrayOf(
//        R.string.followers,
//        R.string.following
//    )
//
//    private lateinit var binding: ActivityDetailBinding
//    private lateinit var viewModel: DetailViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityDetailBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//
//        supportActionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//            elevation = 0f
//        }
//
////        val username = intent.getStringExtra(EXTRA_USER)
////        viewModel.getDetailUser(username).observe(this, {
////            when(it) {
////                is Resource.Loading -> onLoading()
////                is Resource.Success -> onSuccess(it.data)
////                is Resource.Error -> onFailed(it.message)
////            }
////        })
////    }
//
//
//    fun onLoading() {
//
//    }
//
//    fun onSuccess(data: User?) {
//        binding.apply {
//            tvCompany.text = data?.company
//            tvLocation.text = data?.location
//            tvRepositoryValue.text = data?.repository.toString()
//            tvFollowersValue.text = data?.followers.toString()
//            tvFollowingValue.text = data?.following.toString()
//
//            Glide.with(this@DetailActivity)
//                .load(data?.avatar)
//                .apply(RequestOptions.circleCropTransform())
//                .into(ivAvatar)
//
//            supportActionBar?.title = data?.username
//        }
//
//    }
//
//    fun onFailed(message: String?) {
//
//    }

}