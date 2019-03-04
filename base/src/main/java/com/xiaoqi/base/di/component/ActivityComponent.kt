package com.xiaoqi.base.di.component

import android.app.Activity
import android.content.Context
import com.xiaoqi.base.di.module.ActivityModule
import com.xiaoqi.base.di.scope.ActivityScope
import dagger.Component

/**
 * Created by xujie on 2019/2/20.
 * Mail : 617314917@qq.com
 */
@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun context(): Context

    fun activity(): Activity
}