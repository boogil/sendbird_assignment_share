package com.example.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.example.presentation.R
import com.example.presentation.activity.base.BaseBindingActivity
import com.example.presentation.adapter.ContentsAdapter
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.dialog.ContentsDetailDialogFragment
import com.example.presentation.extensions.collectLatestNotNull
import com.example.presentation.extensions.repeatOnStarted
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * 전체 리스트 Fragment
 */
@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>() {
    override fun getLayoutResId(): Int = R.layout.activity_main
    private val mainViewModel: MainViewModel by viewModels()
    private val initSearchWord = "hello"

    private val contentsAdapter: ContentsAdapter by lazy {
        ContentsAdapter.newInstance(
            itemClickListener = { content ->
                ContentsDetailDialogFragment.newInstance(content.isbn13).show(supportFragmentManager, null)
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        setupObserver()
    }

    private fun setupView() {
        binding.svSearch.setQuery(initSearchWord, true)
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(word: String?): Boolean {
                word?.let { mainViewModel.updateSearchWord(it) }
                contentsAdapter.refresh()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean = false
        })

        binding.rvContents.adapter = contentsAdapter
    }

    private fun setupObserver() {
        repeatOnStarted {
            mainViewModel.searchBooks(initSearchWord).collectLatestNotNull { pagingData ->
                contentsAdapter.submitData(pagingData = pagingData)
            }
        }
    }
}