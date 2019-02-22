package com.xiaoqi.topic.ui

import android.view.View
import com.xiaoqi.base.BaseMvpFragment
import com.xiaoqi.topic.R
import com.xiaoqi.topic.mvp.TopicContract

/**
 * Created by xujie on 2019/2/21.
 * Mail : 617314917@qq.com
 */
class TopicFragment : BaseMvpFragment<TopicContract.Presenter>(), TopicContract.View {

    override fun injectComponent() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_topic
    }

    override fun initView(view: View) {
    }

    override fun initData() {
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