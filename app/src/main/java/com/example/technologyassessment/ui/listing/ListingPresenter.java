package com.example.technologyassessment.ui.listing;

import com.example.technologyassessment.data.network.requset.DataManager;
import com.example.technologyassessment.data.network.response.Articles;
import com.example.technologyassessment.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListingPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private final DataManager dataManager;

    @Inject
    public ListingPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getArticles() {
        checkViewAttached();
        getView().showProgress(true);

        Single<Articles> observe = dataManager.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        SingleObserver<Articles> observer = new SingleObserver<Articles>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Articles articles) {
                getView().showProgress(false);
                getView().showArticles(articles);
            }

            @Override
            public void onError(Throwable e) {
                getView().showProgress(false);
                getView().showError(e);
            }
        };
        observe.subscribe(observer);
    }
}
