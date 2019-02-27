package com.xiaoqi.topic.mvp

import com.xiaoqi.base.mvp.presenter.BasePresenter
import com.xiaoqi.base.mvp.view.BaseView
import com.xiaoqi.topic.model.bean.Topic

/**
 * Created by xujie on 2019/2/21.
 * Mail : 617314917@qq.com
 */
interface TopicContract {

    interface View: BaseView {
        fun showTopic(topicList: MutableList<Topic>)
    }

    interface Presenter: BasePresenter {

        fun listTopic()

        fun listTopic(lastCursor: Int, forceUpdate: Boolean, cleanCache: Boolean)

        fun getTopicLastOrder(): Int
    }
}