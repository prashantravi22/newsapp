package com.byjus.news.news.ui.adapter

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.byjus.news.R
import com.byjus.news.core.utils.inflate
import com.byjus.news.databinding.RowNewsArticleBinding
import com.byjus.news.news.storage.entity.NewsArticleDb
import com.byjus.news.news.ui.model.NewsAdapterEvent
import java.text.SimpleDateFormat
import java.util.*


/**
 * The News adapter to show the news in a list.
 */
class NewsArticlesAdapter(
        private val listener: (NewsAdapterEvent) -> Unit
) : ListAdapter<NewsArticleDb, NewsArticlesAdapter.NewsHolder>(DIFF_CALLBACK) {

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsHolder(parent.inflate(R.layout.row_news_article))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) = newsHolder.bind(getItem(position), listener)

    /**
     * View Holder Pattern
     */
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = RowNewsArticleBinding.bind(itemView)

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticleDb, listener: (NewsAdapterEvent) -> Unit) = with(itemView) {
            val customfontTitle = Typeface.createFromAsset(itemView.context.getAssets(), "fonts/RobotoSlab-Bold.ttf")
            val customfontSubTitle = Typeface.createFromAsset(itemView.context.getAssets(), "fonts/RobotoSlab-Regular.ttf")
            binding.newsTitle.setTypeface(customfontTitle)
            binding.newsTitle.text = newsArticle.title
            binding.newsAuthor.text = newsArticle.author
            binding.newsAuthor.setTypeface(customfontSubTitle)
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)

            var date = newsArticle.publishedAt
            var spf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val newDate: Date = spf.parse(date)
            spf = SimpleDateFormat("yyyy MM dd")
            date = spf.format(newDate)
            binding.newsPublishedAt.text = date
            binding.newsPublishedAt.setTypeface(customfontSubTitle)
            binding.newsImage.load(newsArticle.urlToImage) {
                placeholder(R.drawable.tools_placeholder)
                error(R.drawable.tools_placeholder)
            }
            setOnClickListener { listener(NewsAdapterEvent.ClickEvent) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NewsArticleDb>() {
            override fun areItemsTheSame(oldItem: NewsArticleDb, newItem: NewsArticleDb): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: NewsArticleDb, newItem: NewsArticleDb): Boolean = oldItem == newItem
        }
    }
}