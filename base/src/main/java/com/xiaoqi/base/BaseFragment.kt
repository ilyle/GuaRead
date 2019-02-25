package com.xiaoqi.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        init()
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initData()
        setListener()
    }

    /**
     * 获取布局文件R.layout.fragment_abc
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化操作
     */
    open fun init() { }

    /**
     * 初始化布局
     */
    abstract fun initView(view: View)

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 设置监听器
     */
    open fun setListener() { }
}