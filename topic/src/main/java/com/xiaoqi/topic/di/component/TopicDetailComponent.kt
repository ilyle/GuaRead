package com.xiaoqi.topic.di.component

import com.xiaoqi.base.di.component.ActivityComponent
import com.xiaoqi.base.di.scope.PerComponentScope
import com.xiaoqi.topic.di.module.TopicDetailModule
import com.xiaoqi.topic.di.module.TopicModule
import com.xiaoqi.topic.ui.activity.TopicDetailActivity
import com.xiaoqi.topic.ui.fragment.TopicFragment
import dagger.Component

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */

@PerComponentScope
@Component(modules = [TopicDetailModule::class], dependencies = [ActivityComponent::class])
interface TopicDetailComponent {

    fun inject(fragment: TopicDetailActivity)
}