package com.trust.home.security.ui.login;

import android.os.Handler;

import com.trust.home.security.base.BasePresenter;
import com.trust.home.security.utils.AppConstance;

public class LoginPresenter extends BasePresenter<LoginView> {
    private static final String DEFAULT_USER = "admin";
    private static final String DEFAULT_PASSWORD = "admin";

    public void login(String username, String password) {
        view.showLoading();
        new Handler().postDelayed(() -> {
            if(username.equals(DEFAULT_USER) && password.equals(DEFAULT_PASSWORD)) {
                view.onLoginSuccess();
            } else view.onError("Account name or password is incorrect");
            view.hideLoading();
        }, 1500);
    }
}
