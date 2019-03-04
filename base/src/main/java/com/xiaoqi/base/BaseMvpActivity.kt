package com.xiaoqi.base

import com.xiaoqi.base.di.component.DaggerActivityComponent
import com.xiaoqi.base.di.module.ActivityModule
import com.xiaoqi.base.mvp.presenter.BasePresenter
import com.xiaoqi.base.mvp.view.BaseView
import javax.inject.Inject

/**
 * Created by xujie on 2019/2/21.
 * Mail : 617314917@qq.com
 */
abstract class BaseMvpActivity<T : BasePresenter> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: DaggerActivityComponent


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe()
    }

    override fun initOther() {
        initActivityInjection()
        initComponent()
    }

    private fun initActivityInjection() {
        mActivityComponent =
            DaggerActivityComponent.builder().activityModule(ActivityModule(this)).applicationComponent((application as BaseApplication).mApplicationComponent).build() as DaggerActivityComponent
    }

    abstract fun initComponent()
}