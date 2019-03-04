package com.xiaoqi.base

import android.app.Activity
import com.xiaoqi.base.di.component.DaggerActivityComponent
import com.xiaoqi.base.di.module.ActivityModule
import com.xiaoqi.base.mvp.presenter.BasePresenter
import com.xiaoqi.base.mvp.view.BaseView
import javax.inject.Inject

/**
 * Created by xujie on 2019/2/20.
 * Mail : 617314917@qq.com
 */
abstract class BaseMvpFragment<T : BasePresenter> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: DaggerActivityComponent


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe()
    }

    override fun init() {
        initActivityInjection()
        injectComponent()
    }

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(activity as Activity))
            .applicationComponent((activity?.application as BaseApplication).mApplicationComponent)
            .build() as DaggerActivityComponent
    }

    /**
     * 注册依赖关系
     */
    abstract fun injectComponent()
}