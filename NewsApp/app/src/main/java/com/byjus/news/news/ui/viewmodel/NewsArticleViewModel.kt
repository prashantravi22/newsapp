package com.byjus.news.news.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.byjus.news.core.ui.ViewState
import com.byjus.news.news.domain.NewsRepository
import com.byjus.news.news.storage.entity.NewsArticleDb

/**
 * A container for [NewsArticleDb] related data to show on the UI.
 */
class NewsArticleViewModel @ViewModelInject constructor(
        newsRepository: NewsRepository
) : ViewModel() {

    private val newsArticleDb: LiveData<ViewState<List<NewsArticleDb>>> = newsRepository.getNewsArticles().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getNewsArticles(): LiveData<ViewState<List<NewsArticleDb>>> = newsArticleDb
}