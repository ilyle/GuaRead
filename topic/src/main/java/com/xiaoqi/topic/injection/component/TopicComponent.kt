package com.xiaoqi.topic.injection.component

import com.xiaoqi.base.injection.component.ActivityComponent
import com.xiaoqi.base.injection.module.ActivityModule
import com.xiaoqi.base.injection.scope.PerComponentScope
import com.xiaoqi.topic.injection.module.TopicModule
import com.xiaoqi.topic.ui.TopicFragment
import dagger.Component

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */

@PerComponentScope
@Component(modules = [TopicModule::class], dependencies = [ActivityComponent::class])
interface TopicComponent {

    fun inject(fragment: TopicFragment)
}