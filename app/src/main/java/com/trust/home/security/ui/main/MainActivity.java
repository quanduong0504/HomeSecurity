package com.trust.home.security.ui.main;

import android.view.LayoutInflater;

import com.trust.home.security.base.BaseActivity;
import com.trust.home.security.base.BasePagerAdapter;
import com.trust.home.security.databinding.ActivityMainBinding;
import com.trust.home.security.helpers.BundleFactory;
import com.trust.home.security.ui.home.HomeFragment;
import com.trust.home.security.ui.notification.NotificationFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter, MainView> implements MainView {
    private BasePagerAdapter pagerAdapter;
    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected ActivityMainBinding binding(LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater);
    }

    @Override
    protected MainView attachPresenter() {
        return this;
    }

    @Override
    protected void initViews() {
        pagerAdapter = new BasePagerAdapter(getSupportFragmentManager());
        pagerAdapter.setFragments(
                HomeFragment.newInstance(HomeFragment.class),
                NotificationFragment.newInstance(NotificationFragment.class)
        );
        mBinding.viewPager.setAdapter(pagerAdapter);
    }

    @Override
    protected void initActions() {

    }
}