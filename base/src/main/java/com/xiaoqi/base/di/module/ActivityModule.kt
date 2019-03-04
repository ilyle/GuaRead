package com.xiaoqi.base.di.module

import android.app.Activity
import com.xiaoqi.base.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by xujie on 2019/2/20.
 * Mail : 617314917@qq.com
 */

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}