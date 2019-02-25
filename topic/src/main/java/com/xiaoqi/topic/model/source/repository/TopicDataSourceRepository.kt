package com.xiaoqi.topic.model.source.repository

import com.xiaoqi.topic.model.bean.Topic
import com.xiaoqi.topic.model.source.TopicDataSource
import com.xiaoqi.topic.model.source.remote.TopicDataSourceRemote
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */
class TopicDataSourceRepository @Inject constructor(): TopicDataSource {

    @Inject
    lateinit var remote: TopicDataSourceRemote

    override fun listTopic(): Observable<MutableList<Topic>>? {
        return remote.listTopic()
    }
}