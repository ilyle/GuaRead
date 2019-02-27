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
    fun listTopic(): Observable<MutableList<Topic>>

    /**
     * 根据页数列出热门话题
     *
     * @param lastCursor 页数（每页默认10条）
     * @param forceUpdate 是否强制更新
     * @param cleanCache 是否清除缓存
     */
    fun listTopic(lastCursor: Int, forceUpdate: Boolean, cleanCache: Boolean): Observable<MutableList<Topic>>

    /**
     * 获取最后一篇文章的order
     */
    fun getTopicLastCursor(): Int
}