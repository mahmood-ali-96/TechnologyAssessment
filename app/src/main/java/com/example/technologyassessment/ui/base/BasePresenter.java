package com.example.technologyassessment.ui.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * The type Base presenter.
 *
 * @param <V> the type parameter
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private V mvpView;

    @Override
    public void attachView(V view) {
        this.mvpView = view;
    }

    @Override
    public void detachView() {
        mvpView = null;
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

    @Override
    public boolean isViewAttached() {
        return mvpView != null;
    }

    @Override
    public V getView() {
        return mvpView;
    }

    /**
     * Check view attached.
     */
    protected void checkViewAttached() {
        if(!isViewAttached()) {
            throw new ViewNotAttachedException();
        }
    }

    /**
     * Add disposable.
     *
     * @param disposable the disposable
     */
    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    private static class ViewNotAttachedException extends RuntimeException {
        /**
         * Instantiates a new View not attached exception.
         */
        ViewNotAttachedException() {
            super(
                    "Please call Presenter.attachView(BaseView) before"
                            + " requesting data to the Presenter");
        }
    }
}
