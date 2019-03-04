package com.xiaoqi.topic.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import com.xiaoqi.base.BaseMvpActivity
import com.xiaoqi.topic.R
import com.xiaoqi.topic.contract.TopicDetailContract
import com.xiaoqi.topic.di.component.DaggerTopicDetailComponent
import com.xiaoqi.topic.di.module.TopicDetailModule
import com.xiaoqi.topic.model.bean.Topic
import com.xiaoqi.topic.presenter.TopicDetailPresenter
import com.xiaoqi.topic.ui.adapter.NewsRvAdapter
import com.xiaoqi.topic.util.TimeUtil
import kotlinx.android.synthetic.main.activity_topic_detail.*

/**
 * Created by xujie on 2019/3/1.
 * Mail : 617314917@qq.com
 */
class TopicDetailActivity : BaseMvpActivity<TopicDetailPresenter>(), TopicDetailContract.View {

    private lateinit var mAdapter: NewsRvAdapter

    private var mTopic: Topic? = null

    override fun initComponent() {
        DaggerTopicDetailComponent.builder()
            .activityComponent(mActivityComponent)
            .topicDetailModule(TopicDetailModule(this))
            .build()
            .inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_topic_detail
    }

    override fun initView() {
        /**
         * 话题详情
         */
        rv_topic_detail_news.adapter = mAdapter
        rv_topic_detail_news.layoutManager = LinearLayoutManager(this@TopicDetailActivity)
        /**
         * 新闻列表
         */
        tv_topic_detail_title.text = mTopic?.title
        tv_topic_detail_date.text = TimeUtil.getFormatDateDesc(mTopic?.publishDate!!)
        tv_topic_detail_content.text = mTopic?.summary
    }

    override fun initData() {
        intent?.let {
            mTopic = it.getParcelableExtra(OBJ)
        }

        mTopic?.newsArray?.let {
            mAdapter = NewsRvAdapter(this@TopicDetailActivity, it)
        } ?: let {
            mAdapter = NewsRvAdapter(this@TopicDetailActivity, mutableListOf())
        }

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showEmpty() {

    }

    override fun showError() {

    }

    companion object {

        fun startAction(context: Context, obj: Parcelable) {
            val intent = Intent(context, TopicDetailActivity::class.java)
            intent.putExtra(OBJ, obj)
            context.startActivity(intent)
        }

        private const val OBJ = "obj"
    }
}
