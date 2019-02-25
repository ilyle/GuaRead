package com.xiaoqi.topic.injection.module

import com.xiaoqi.topic.model.source.TopicDataSource
import com.xiaoqi.topic.model.source.repository.TopicDataSourceRepository
import com.xiaoqi.topic.mvp.TopicContract
import dagger.Module
import dagger.Provides

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */
@Module
class TopicModule(private val view: TopicContract.View) {

    @Provides
    fun provideDataSource(topicDataSource: TopicDataSourceRepository): TopicDataSource {
        return topicDataSource
    }

    @Provides
    fun provideView(): TopicContract.View {
        return this.view
    }

}