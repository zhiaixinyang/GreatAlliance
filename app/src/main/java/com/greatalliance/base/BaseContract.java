package com.greatalliance.base;

/**
 * Created by MBENBEN on 2017/7/9.
 */

public interface BaseContract {
    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {

        void showError();

        void complete();

    }
}
