package com.trust.home.security;

import android.app.Application;

public class HomeSecurityApplication extends Application {
    public static HomeSecurityApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
