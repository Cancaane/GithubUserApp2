package com.example.githubuserapp2.activity

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuserapp2.R
import com.example.githubuserapp2.Resource
import com.example.githubuserapp2.ViewStateCallBack
import com.example.githubuserapp2.adapter.UserAdapter
import com.example.githubuserapp2.databinding.ActivityMainBinding
import com.example.githubuserapp2.response.User
import com.example.githubuserapp2.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), ViewStateCallBack<List<User>> {

    private lateinit var binding: ActivityMainBinding
    private lateinit var user: String
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        userAdapter = UserAdapter()
        binding.rvListUser.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        binding.search.apply {
            queryHint = resources.getString(R.string.search_hint)
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    user = query.toString()
                    viewModel.searchUser(user).observe(this@MainActivity, {
                        when (it) {
                            is Resource.Error -> onFailed(it.message)
                            is Resource.Loading -> onLoading()
                            is Resource.Success -> it.data?.let { it1 -> onSuccess(it1) }
                        }
                    })
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
        }

    }

    override fun onLoading() {
        binding.apply {
            mainProgressBar.visibility = invisible
        }
    }

    override fun  onSuccess(data: List<User>) {
        userAdapter.setAllData(data)
        binding.apply {
            rvListUser.visibility = visible
            mainProgressBar.visibility = invisible
        }
    }

    override fun onFailed(message: String?) {
        binding.apply {
            rvListUser.visibility = invisible
            mainProgressBar.visibility = visible
        }
    }
}