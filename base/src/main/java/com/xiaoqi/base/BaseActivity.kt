package com.xiaoqi.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by xujie on 2019/2/19.
 * Mail : 617314917@qq.com
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initView()
        initOther()
        setListener()
    }

    /**
     * 获取布局文件R.layout.activity_abc
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化布局
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化其他
     */
    open fun initOther() {

    }

    /**
     * 设置监听器
     */
    open fun setListener() {

    }

}