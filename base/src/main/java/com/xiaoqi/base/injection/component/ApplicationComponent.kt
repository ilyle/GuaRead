package com.xiaoqi.base.injection.component

import android.content.Context
import com.xiaoqi.base.injection.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by xujie on 2019/2/20.
 * Mail : 617314917@qq.com
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun context(): Context
}