package com.xiaoqi.base

import android.app.Application
import android.content.Context
import com.xiaoqi.base.injection.component.DaggerApplicationComponent
import com.xiaoqi.base.injection.module.ApplicationModule

/**
 * Created by xujie on 2019/2/19.
 * Mail : 617314917@qq.com
 */
open class BaseApplication : Application() {

    lateinit var mApplicationComponent: DaggerApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initInjection()

        instance = this
    }

    private fun initInjection() {
        mApplicationComponent =
            DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build() as DaggerApplicationComponent
    }

    companion object {
        private lateinit var instance: BaseApplication

        @JvmStatic
        fun getContext(): Context {
            return instance.applicationContext
        }

    }
}