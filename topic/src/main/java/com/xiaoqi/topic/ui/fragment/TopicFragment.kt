package com.xiaoqi.topic.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.xiaoqi.base.BaseMvpFragment
import com.xiaoqi.topic.R
import com.xiaoqi.topic.di.module.TopicModule
import com.xiaoqi.topic.model.bean.Topic
import com.xiaoqi.topic.contract.TopicContract
import com.xiaoqi.topic.di.component.DaggerTopicComponent
import com.xiaoqi.topic.presenter.TopicPresent
import com.xiaoqi.topic.ui.adapter.TopicRvAdapter
import kotlinx.android.synthetic.main.fragment_topic.*
import javax.inject.Inject

/**
 * Created by xujie on 2019/2/21.
 * Mail : 617314917@qq.com
 */
class TopicFragment : BaseMvpFragment<TopicPresent>(), TopicContract.View {

    private lateinit var mAdapter: TopicRvAdapter

    private var mIsFirstLoad = false

    override fun injectComponent() {
        DaggerTopicComponent.builder()
            .activityComponent(mActivityComponent)
            .topicModule(TopicModule(this))
            .build()
            .inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_topic
    }

    override fun initView(view: View) {

        mAdapter = TopicRvAdapter(context, mutableListOf())
        rv_topic.adapter = mAdapter
        rv_topic.layoutManager = LinearLayoutManager(context)
    }

    override fun initData() {
    }

    override fun setListener() {
        super.setListener()
        srl_topic.setOnRefreshListener { mPresenter.listTopic(0, forceUpdate = true, cleanCache = true) }
        srl_topic.setOnLoadmoreListener { mPresenter.listTopic(mPresenter.getTopicLastOrder(), forceUpdate = true, cleanCache = false) }
    }

    override fun onResume() {
        super.onResume()
        if (mIsFirstLoad) {
            mIsFirstLoad = false
            mPresenter.listTopic(0, forceUpdate = true, cleanCache = true)
        } else {
            mPresenter.listTopic(mPresenter.getTopicLastOrder(), forceUpdate = false, cleanCache = false)
        }
    }

    override fun showTopic(topicList: MutableList<Topic>) {
        mAdapter.update(topicList)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        srl_topic.finishRefresh()
        srl_topic.finishLoadmore()
    }

    override fun showEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance(): TopicFragment {
            return TopicFragment()
        }
    }
}