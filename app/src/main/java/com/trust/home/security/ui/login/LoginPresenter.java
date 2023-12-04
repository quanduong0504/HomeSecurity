package com.trust.home.security.ui.login;

import com.trust.home.security.HomeSecurityApplication;
import com.trust.home.security.base.BasePresenter;
import com.trust.home.security.utils.AppPrefsManager;

import kotlin.Unit;

public class LoginPresenter extends BasePresenter<LoginView> {
    public void login(String username, String password) {
        HomeSecurityApplication.database.selectUserWhere(username, password, user -> {
            if(user != null) {
                AppPrefsManager.getInstance().putUser(user);
                HomeSecurityApplication.database.checkUserIsRegisteredFace(username, isRegistered -> {
                    if (isRegistered) {
                        view.onLoginSuccess();
                    } else view.goToRegisterFace();
                    return Unit.INSTANCE;
                });
            } else view.onLoginFailure("username or password is incorrect");
            return Unit.INSTANCE;
        });
    }
}
