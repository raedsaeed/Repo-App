package com.example.unioncoop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.unioncoop.databinding.ActivityMainBinding
import com.example.unioncoop.di.ViewModelFactory
import com.example.unioncoop.objects.Repo
import com.example.unioncoop.objects.Result
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RepoViewModel
    private lateinit var adapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory)[RepoViewModel::class.java]
        viewModel.getRepoData().observe(this, { populateUI(it) })

        initVars()
    }

    private fun initVars() {
        adapter = RepoAdapter()
        binding.rvActivityMainRepoList.layoutManager = LinearLayoutManager(this)
        binding.rvActivityMainRepoList.adapter = adapter
        binding.rvActivityMainRepoList.addItemDecoration(
            DividerItemDecoration(
                this,
                RecyclerView.VERTICAL
            )
        )
        (binding.rvActivityMainRepoList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations =
            false


        binding.srlActivityMainRefresh.setOnRefreshListener {
            fetchData()
        }

        binding.layoutActivityMainFailure.btnActivityMainRetry.setOnClickListener {
            fetchData()
        }

        fetchData()
    }

    private fun populateUI(result: Result<List<Repo>>) {
        when (result.status) {
            Result.Status.ERROR -> {
                binding.shimmerViewContainer.visibility = View.GONE
                binding.clActivityMainFailureContainer.visibility = View.VISIBLE
                binding.rvActivityMainRepoList.visibility = View.GONE
                binding.srlActivityMainRefresh.isRefreshing = false
            }

            Result.Status.LOADING -> {
                binding.shimmerViewContainer.startShimmerAnimation()
                binding.shimmerViewContainer.visibility = View.VISIBLE
                binding.srlActivityMainRefresh.isRefreshing = adapter.itemCount != 0
                binding.clActivityMainFailureContainer.visibility = View.GONE
            }

            Result.Status.SUCCESS -> {
                binding.shimmerViewContainer.stopShimmerAnimation()
                binding.rvActivityMainRepoList.visibility = View.VISIBLE
                binding.srlActivityMainRefresh.isRefreshing = false
                populateAdapter(result.data)
            }
        }
    }

    private fun populateAdapter(data: List<Repo>?) {
        adapter.setItems(data?.toMutableList()!!)
    }

    private fun fetchData() {
        viewModel.fetchRepos()
    }
}