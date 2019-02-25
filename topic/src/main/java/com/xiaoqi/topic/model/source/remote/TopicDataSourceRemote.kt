package com.xiaoqi.topic.model.source.remote

import com.xiaoqi.base.network.RetrofitClient
import com.xiaoqi.topic.model.bean.Topic
import com.xiaoqi.topic.model.source.TopicDataSource
import com.xiaoqi.topic.service.TopicService
import io.reactivex.Observable

import javax.inject.Inject

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */
class TopicDataSourceRemote @Inject constructor() : TopicDataSource {

    override fun listTopic(): Observable<MutableList<Topic>>? {
        return RetrofitClient.getClient()
            .create(TopicService::class.java)
            .listTopic()
            .flatMap {
                Observable.just(it.data) }
    }
}
