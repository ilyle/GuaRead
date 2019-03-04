package com.xiaoqi.topic.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.xiaoqi.topic.R
import com.xiaoqi.topic.model.bean.Topic
import com.xiaoqi.topic.ui.activity.TopicDetailActivity
import com.xiaoqi.topic.util.TimeUtil

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

    inner class TopicHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val cvTopic = view.findViewById<CardView>(R.id.cv_item_topic)
        private val tvTitle = view.findViewById<TextView>(R.id.tv_item_topic_title)
        private val tvContent = view.findViewById<TextView>(R.id.tv_item_topic_content)

        fun setData(position: Int) {
            val topic = mTopicList[position]
            val ssb = SpannableStringBuilder(topic.title + "    " + TimeUtil.getFormatDateDesc(topic.publishDate))
            ssb.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(mContext!!, R.color.text_black_secondary)),
                topic.title.length,
                ssb.toString().length,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            )
            tvTitle.text = ssb
            tvContent.text = topic.summary

            cvTopic.setOnClickListener(this@TopicHolder)
        }


        override fun onClick(v: View?) {
            when (v?.id) {
                /**
                 * 点击CardView跳转WebView
                 */
                R.id.cv_item_topic -> {
                    val topic = mTopicList[adapterPosition]
                    TopicDetailActivity.startAction(mContext!!, topic)
                }
            }
        }
    }
}