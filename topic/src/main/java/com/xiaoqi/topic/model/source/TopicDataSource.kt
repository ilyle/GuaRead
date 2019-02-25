package com.xiaoqi.topic.model.source

import com.xiaoqi.topic.model.bean.Topic
import io.reactivex.Observable

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */
interface TopicDataSource {

    /**
     * 列出热门话题
     */
    fun listTopic(): Observable<MutableList<Topic>>?
}