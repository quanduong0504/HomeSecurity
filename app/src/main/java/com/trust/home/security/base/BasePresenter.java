package com.trust.home.security.base;

import com.trust.home.security.helpers.Preferences;

public class BasePresenter <V extends BaseView> {
    protected V view;
    protected final Preferences preferences;

    public BasePresenter() {
        preferences = Preferences.getInstance();
    }

    public void onAttach(V view) {
        this.view = view;
    }

    public void onDetach() {

    }
}
