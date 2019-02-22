package com.xiaoqi.base.injection.component

import android.app.Activity
import android.content.Context
import com.xiaoqi.base.injection.module.ActivityModule
import com.xiaoqi.base.injection.scope.ActivityScope
import dagger.Component

/**
 * Created by xujie on 2019/2/20.
 * Mail : 617314917@qq.com
 */
@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun context(): Context

    fun activity(): Activity
}