package com.xiaoqi.topic.di.module

import com.xiaoqi.base.mvp.view.BaseView
import com.xiaoqi.topic.contract.TopicContract
import com.xiaoqi.topic.contract.TopicDetailContract
import com.xiaoqi.topic.model.source.TopicDataSource
import com.xiaoqi.topic.model.source.repository.TopicDataSourceRepository
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */
@Module
class TopicDetailModule(private val view: TopicDetailContract.View) {

    @Provides
    fun provideDataSource(dataSource: TopicDataSourceRepository): TopicDataSource {
        return dataSource
    }

    @Provides
    fun provideView(): TopicDetailContract.View {
        return this.view
    }

    @Provides
    fun provideDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}