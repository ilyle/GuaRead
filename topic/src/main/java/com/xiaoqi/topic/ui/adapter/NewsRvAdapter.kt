package com.xiaoqi.topic.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.xiaoqi.topic.R
import com.xiaoqi.topic.model.bean.News

class NewsRvAdapter(context: Context?, newsList: MutableList<News>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mContext = context
    private var mNewsList = newsList

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return NewsHolder(LayoutInflater.from(mContext).inflate(R.layout.item_news, p0, false))
    }

    override fun getItemCount(): Int {
        return mNewsList.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val newsHolder = p0 as NewsHolder
        newsHolder.setData(p1)
    }

    fun update(newsList: List<News>) {
        mNewsList.clear()
        mNewsList.addAll(newsList)
        notifyDataSetChanged()
        notifyItemChanged(newsList.size)
    }

    inner class NewsHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val tvNews = view.findViewById<TextView>(R.id.tv_item_news)

        fun setData(position: Int) {
            val news = mNewsList[position]
            tvNews.text = news.title
            tvNews.setOnClickListener(this@NewsHolder)
        }

        override fun onClick(v: View?) {
            when (v?.id) {

            }
        }
    }
}