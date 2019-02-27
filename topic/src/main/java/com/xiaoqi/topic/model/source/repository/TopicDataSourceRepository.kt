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
class TopicDataSourceRepository @Inject constructor() : TopicDataSource {

    @Inject
    lateinit var mRemote: TopicDataSourceRemote

    /**
     * 话题缓存
     */
    private var mTopicCache: MutableList<Topic>? = null

    override fun listTopic(): Observable<MutableList<Topic>> {
        return mRemote.listTopic()
    }

    override fun listTopic(
        lastCursor: Int,
        forceUpdate: Boolean,
        cleanCache: Boolean
    ): Observable<MutableList<Topic>> {
        /**
         * 不更新，不清缓存，缓存不为空，即按Home键返回桌面再进入App情景，此时返回缓存列表
         */
        if (!forceUpdate && !cleanCache && mTopicCache != null) {
            return Observable.fromArray(mTopicCache)
        }
        /*
         * 更新，不清缓存，缓存不为空，即上拉加载更多情景，此时合并缓存和新数据
         */
        else if (forceUpdate && !cleanCache && mTopicCache != null) {
            val cache = Observable.fromArray(mTopicCache)

            val update = mRemote.listTopic(lastCursor, forceUpdate = true, cleanCache = false)
                .doOnNext { refreshTopicCache(cleanCache, it) }

            return Observable.merge(cache, update).collect({ mutableListOf<Topic>() }, { t1, t2 -> t1.addAll(t2!!) })
                .toObservable()
        }
        /**
         * 更新，清除缓存，此时返回新数据
         */
        return mRemote.listTopic(0, forceUpdate = true, cleanCache = true)
            .doOnNext { refreshTopicCache(cleanCache, it) }

    }

    override fun getTopicLastCursor(): Int {
        return if (mTopicCache != null) {
            mTopicCache!![mTopicCache!!.size - 1].order
        } else {
            0
        }
    }

    /**
     * 刷新文章缓存
     */
    private fun refreshTopicCache(cleanCache: Boolean, articleList: MutableList<Topic>?) {
        if (mTopicCache == null) {
            mTopicCache = mutableListOf()
        }
        if (cleanCache) {
            mTopicCache?.clear()
        }
        articleList?.let {
            for (topic in it) {
                mTopicCache?.add(topic)
            }
        }
    }
}