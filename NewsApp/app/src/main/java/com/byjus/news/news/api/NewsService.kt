package com.byjus.news.news.api

import retrofit2.Response
import retrofit2.http.GET

/**
 * Describes endpoints to fetch the news from NewsAPI.
 *
 * Read the documentation [here](https://newsapi.org/docs/v2)
 */
interface NewsService {

    /**
     * Get top headlines.
     *
     * See [article documentation](https://newsapi.org/docs/endpoints/top-headlines).
     */
    @GET("top-headlines?apiKey=e6132bdc8b4145ea9f0284e5f40b7b5f&category=technology")
    suspend fun getTopHeadlines(): Response<NewsResponse>

}
