package com.trust.home.security.ui.profile;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trust.home.security.base.BaseFragment;
import com.trust.home.security.database.entity.User;
import com.trust.home.security.databinding.FragmentProfileViewBinding;
import com.trust.home.security.ui.login.LoginActivity;

public class ProfileFragment
        extends BaseFragment<FragmentProfileViewBinding, ProfilePresenter, ProfileView>
        implements ProfileView {
    @Override
    protected FragmentProfileViewBinding binding(LayoutInflater inflater, ViewGroup container) {
        return FragmentProfileViewBinding.inflate(inflater, container, false);
    }

    @Override
    protected ProfilePresenter getPresenter() {
        return new ProfilePresenter();
    }

    @Override
    protected void initViews() {
        User user = mPresenter.getUserLoggedIn();
        mBinding.tvName.setText(user.getUserName());
    }

    @Override
    protected void initActions() {
        mBinding.btnLogout.setOnClickListener(v -> {
            mPresenter.logout();
            pushActivityAndFinish(LoginActivity.class);
        });
    }

    @Override
    protected ProfileView attachView() {
        return this;
    }
}
