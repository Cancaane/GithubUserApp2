package com.example.githubuserapp2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuserapp2.R
import com.example.githubuserapp2.Resource
import com.example.githubuserapp2.ViewStateCallBack
import com.example.githubuserapp2.adapter.UserAdapter
import com.example.githubuserapp2.databinding.FragmentFollowingBinding
import com.example.githubuserapp2.response.User
import com.example.githubuserapp2.viewModel.FollowingViewModel

class FollowingFragment : Fragment(), ViewStateCallBack<List<User>> {

    companion object {
        private const val KEY_BUNDLE = "USERNAME"

        fun getInstance(username: String) : Fragment {
            return FollowingFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_BUNDLE, username)
                }
            }
        }
    }

    private var binding: FragmentFollowingBinding? = null
    private lateinit var viewModel: FollowingViewModel
    private lateinit var userAdpater: UserAdapter
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(KEY_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(FollowingViewModel::class.java)
        userAdpater = UserAdapter()

        binding?.rvListFollowing?.apply {
            adapter = userAdpater
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.getFollowing(username.toString()).observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> onFailed(it.message)
                is Resource.Loading -> onLoading()
                is Resource.Success -> it.data?.let { it1 -> onSuccess(it1) }
            }
        })
    }

    override fun onLoading() {
        binding?.apply {
            followingProgressBar.visibility = visible
        }
    }

    override fun onSuccess(data: List<User>) {
        userAdpater.setAllData(data)
        binding?.apply {
            followingProgressBar.visibility = invisible
            rvListFollowing.visibility = visible
        }
    }

    override fun onFailed(message: String?) {
        binding?.apply {
            if (message == null){
                tvMessage.text = resources.getString(R.string.following_not_found)
                tvMessage.visibility = visible
            } else {
                tvMessage.visibility = visible
            }
        }
    }
}