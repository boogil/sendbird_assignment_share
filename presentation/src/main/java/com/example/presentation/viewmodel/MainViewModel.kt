package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.entity.BookDetailEntity
import com.example.domain.entity.BookEntity
import com.example.domain.usecase.GetBookDetail
import com.example.domain.usecase.GetBooks
import com.example.presentation.dataSource.BookDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getBooks: GetBooks,
                                        private val getBookDetail: GetBookDetail) : ViewModel() {

    private var bookDataSource: BookDataSource? = null

    fun searchBooks(searchWord: String): StateFlow<PagingData<BookEntity>?> {
        bookDataSource = BookDataSource(searchWord, getBooks)
        return Pager(
            config = PagingConfig(pageSize = BookDataSource.PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { bookDataSource!! }
        ).flow.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
    }

    fun updateSearchWord(searchWord: String) {
        bookDataSource = BookDataSource(searchWord, getBooks)
    }

    fun fetchBookDetail(id: String): StateFlow<BookDetailEntity?> =
        flow { emit(getBookDetail.invoke(id).getOrNull()) }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
}