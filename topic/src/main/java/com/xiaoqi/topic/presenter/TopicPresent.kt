package com.xiaoqi.topic.presenter

import com.xiaoqi.topic.model.bean.Topic
import com.xiaoqi.topic.model.source.TopicDataSource
import com.xiaoqi.topic.contract.TopicContract
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

    @Inject
    lateinit var mDisposable: CompositeDisposable

    override fun listTopic(lastCursor: Int, forceUpdate: Boolean, cleanCache: Boolean) {
        val disposable: Disposable = mModel.listTopic(lastCursor, forceUpdate, cleanCache)
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
        mDisposable.clear()
    }
}
