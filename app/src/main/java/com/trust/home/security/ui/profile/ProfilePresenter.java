package com.trust.home.security.ui.profile;

import com.trust.home.security.base.BasePresenter;
import com.trust.home.security.database.entity.User;
import com.trust.home.security.utils.AppPrefsManager;

public class ProfilePresenter extends BasePresenter<ProfileView> {
    public void logout() {
        AppPrefsManager.getInstance().logout();
    }

    public User getUserLoggedIn() {
        return AppPrefsManager.getInstance().getUser();
    }
}
