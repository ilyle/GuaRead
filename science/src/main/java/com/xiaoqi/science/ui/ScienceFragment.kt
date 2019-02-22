package com.xiaoqi.science.ui

import android.view.View
import com.xiaoqi.base.BaseMvpFragment
import com.xiaoqi.science.R
import com.xiaoqi.science.mvp.ScienceContract

/**
 * Created by xujie on 2019/2/21.
 * Mail : 617314917@qq.com
 */
class ScienceFragment : BaseMvpFragment<ScienceContract.Presenter>(), ScienceContract.View {

    override fun injectComponent() {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_science
    }

    override fun initView(view: View) {
    }

    override fun initData() {
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance(): ScienceFragment {
            return ScienceFragment()
        }
    }
}