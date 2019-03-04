package com.xiaoqi.topic.presenter;

import com.xiaoqi.topic.contract.TopicDetailContract;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

/**
 * Created by xujie on 2019/3/1.
 * Mail : 617314917@qq.com
 */
public class TopicDetailPresenter implements TopicDetailContract.Presenter {

    @Inject
    public TopicDetailPresenter() {

    }

    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mDisposable.clear();
    }
}
