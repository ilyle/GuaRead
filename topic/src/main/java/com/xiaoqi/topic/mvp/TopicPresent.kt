package com.xiaoqi.topic.mvp

import android.util.Log
import com.xiaoqi.topic.model.bean.Topic
import com.xiaoqi.topic.model.source.TopicDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by xujie on 2019/2/22.
 * Mail : 617314917@qq.com
 */
class TopicPresent @Inject constructor(): TopicContract.Presenter {

    @Inject
    lateinit var mView: TopicContract.View

    @Inject
    lateinit var mModel: TopicDataSource

    private val mDisposable: CompositeDisposable = CompositeDisposable()

    override fun listTopic() {
        val disposable: Disposable = mModel.listTopic()!!
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<MutableList<Topic>>() {
                override fun onComplete() {
                    Log.i("xuj", "fafafa")
                }

                override fun onNext(t: MutableList<Topic>) {
                    Log.i("xuj", "fafafa")
                }

                override fun onError(e: Throwable) {
                    Log.i("xuj", "fafafa")
                }

            })
        mDisposable.add(disposable)
    }

    override fun listTopic(lastCursor: Int, forceUpdate: Boolean, cleanCache: Boolean) {
        val disposable: Disposable = mModel.listTopic(lastCursor, forceUpdate, cleanCache)!!
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<MutableList<Topic>>() {
                override fun onComplete() {
                    mView.hideLoading()
                }

                override fun onNext(t: MutableList<Topic>) {
                    mView.showTopic(t)
                }

                override fun onError(e: Throwable) {
                    mView.hideLoading()
                }

            })
        mDisposable.add(disposable)
    }

    override fun getTopicLastOrder(): Int {
        return mModel.getTopicLastCursor()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }
}
