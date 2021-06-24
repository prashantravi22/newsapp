package com.byjus.news.news.ui.model

import com.byjus.news.news.ui.adapter.NewsArticlesAdapter

/**
 * Describes all the events originated from
 * [NewsArticlesAdapter].
 */
sealed class NewsAdapterEvent {

    /* Describes item click event  */
    object ClickEvent : NewsAdapterEvent()
}