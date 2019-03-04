package com.xiaoqi.guaread

import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.xiaoqi.base.BaseActivity
import com.xiaoqi.base.BaseFragment
import com.xiaoqi.provider.ModuleConfig
import com.xiaoqi.provider.Router
import com.xiaoqi.science.ui.ScienceFragment
import com.xiaoqi.topic.ui.fragment.TopicFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var mTopicFragment: BaseFragment? = null
    private var mScienceFragment: BaseFragment? = null
    private var mDeveloperFragment: BaseFragment? = null
    private var mChaimFragment: BaseFragment? = null
    private var mMineFragment: BaseFragment? = null
    private val mStack = Stack<BaseFragment>()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        initFragment()
    }

    override fun initData() {
    }

    override fun setListener() {
        bnv_main.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tab_topic -> showFragment(0)
            R.id.tab_science -> showFragment(1)
        }
        return true
    }

    /**
     * 初始化fragment
     */
    private fun initFragment() {
        val bt = supportFragmentManager.beginTransaction()

        for (module in Router.modules) {
            when (module) {
                ModuleConfig.MODULE_TOPIC -> mTopicFragment = TopicFragment.newInstance()
                ModuleConfig.MODULE_SCIENCE -> mScienceFragment = ScienceFragment.newInstance()
            }
        }

        mTopicFragment?.let {
            bt.add(R.id.fl_main, it)
            mStack.add(it)
        }

        mScienceFragment?.let {
            bt.add(R.id.fl_main, it)
            mStack.add(it)
        }

        if (mStack.size != 0) {
            bt.commit()
        }

        showFragment(0)
    }

    /**
     * 切换fragment显示
     * @param position Int
     */
    private fun showFragment(position: Int) {
        if (position >= mStack.size) {
            return
        }
        val bt = supportFragmentManager.beginTransaction()
        mStack.forEach {
            bt.hide(it)
        }
        bt.show(mStack[position])
        bt.commit()
    }
}
