package com.xiaoqi.topic.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.xiaoqi.topic.R
import com.xiaoqi.topic.model.bean.Topic

class TopicRvAdapter(context: Context?, topicList: MutableList<Topic>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mContext = context
    private var mTopicList = topicList

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return TopicHolder(LayoutInflater.from(mContext).inflate(R.layout.item_topic, p0, false))
    }

    override fun getItemCount(): Int {
        return mTopicList.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val topicHolder = p0 as TopicHolder
        topicHolder.setData(p1)
    }

    fun update(topicList: List<Topic>) {
        mTopicList.clear()
        mTopicList.addAll(topicList)
        notifyDataSetChanged()
        notifyItemChanged(topicList.size)
    }

    inner class TopicHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle = view.findViewById<TextView>(R.id.tv_item_topic_title)
        private val tvContent = view.findViewById<TextView>(R.id.tv_item_topic_content)
        private val llView = view.findViewById<LinearLayout>(R.id.ll_item_topic_view)

        fun setData(position: Int) {
            val topic = mTopicList[position]
            tvTitle.text = topic.title
            tvContent.text = topic.summary
            topic.extra?.instantView?.let { llView.visibility = if (it) View.VISIBLE else View.GONE }
        }

    }
}