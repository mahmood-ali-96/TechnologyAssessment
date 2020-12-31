package com.example.technologyassessment.ui.listing;


import com.example.technologyassessment.data.network.response.Articles;
import com.example.technologyassessment.ui.base.BaseView;
import com.example.technologyassessment.ui.base.Presenter;

import java.util.List;

class MainContract {

    // Action callbacks. Activity/Fragment will implement
    interface View extends BaseView {

        void showArticles(Articles articles);

        void showProgress(boolean show);

        void showError(Throwable error);
    }

    interface Presenter extends com.example.technologyassessment.ui.base.Presenter<View> {
        void getArticles();
    }

}
