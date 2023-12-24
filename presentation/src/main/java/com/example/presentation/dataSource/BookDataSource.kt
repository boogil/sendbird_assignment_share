package com.example.presentation.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.entity.BookEntity
import com.example.domain.usecase.GetBooks

class BookDataSource(private val searchWord: String, private val getBooks: GetBooks) : PagingSource<Int, BookEntity>() {
    private val orQuery = "|"
    private val exceptQuery = "-"

    override fun getRefreshKey(state: PagingState<Int, BookEntity>): Int = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BookEntity> {
        return try {
            val page = params.key ?: START_PAGE
            val books = fetchBooksUsingQuery(query = searchWord, page = page)
            val nextPage = if (books.isEmpty()) null else page.plus(1)
            LoadResult.Page(data = books, nextKey = nextPage, prevKey = null)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private suspend fun fetchBooksUsingQuery(query: String, page: Int): List<BookEntity> {
        val books = arrayListOf<BookEntity>()
        when {
            orQuery in query -> {
                query.split(orQuery).forEach {
                    books.addAll(getBooks.invoke(searchWord = it, page = page).getOrNull()?.books ?: emptyList())
                }
                books.shuffle()
            }
            exceptQuery in query -> {
                val words = query.split(exceptQuery)
                val searchWord = words.getOrNull(0).toString()
                val exceptWord = words.getOrNull(1)
                books.addAll(getBooks.invoke(searchWord = searchWord, page = page).getOrNull()?.books?.filterNot {
                    it.title?.contains(exceptWord.toString(), ignoreCase = true) ?: false
                } ?: emptyList())
            }
            else -> books.addAll(getBooks.invoke(searchWord = searchWord, page = page).getOrNull()?.books ?: emptyList())
        }

        return books
    }

    companion object {
        const val PAGE_SIZE = 20
        const val START_PAGE = 1
    }
}