package com.xiaoqi.topic.ui

import android.view.View
import com.xiaoqi.base.BaseMvpFragment
import com.xiaoqi.topic.R
import com.xiaoqi.topic.injection.component.DaggerTopicComponent
import com.xiaoqi.topic.injection.module.TopicModule
import com.xiaoqi.topic.mvp.TopicContract
import com.xiaoqi.topic.mvp.TopicPresent

/**
 * Created by xujie on 2019/2/21.
 * Mail : 617314917@qq.com
 */
class TopicFragment : BaseMvpFragment<TopicPresent>(), TopicContract.View {

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
    }

    override fun initData() {
        mPresenter.listTopic()
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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