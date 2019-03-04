package com.xiaoqi.topic.service

import com.xiaoqi.topic.service.api.Api
import com.xiaoqi.topic.model.bean.TopicData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */
interface TopicService {

    @GET(Api.TOPIC)
    fun listTopic(): Observable<TopicData>

    @GET(Api.TOPIC)
    fun listTopic(@Query("lastCursor") lastCursor: Int, @Query("pageSize") pageSize: Int): Observable<TopicData>
}