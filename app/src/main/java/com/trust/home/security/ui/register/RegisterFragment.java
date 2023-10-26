package com.trust.home.security.ui.register;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trust.home.security.base.BaseFragment;
import com.trust.home.security.databinding.FragmentRegisterBinding;

public class RegisterFragment extends BaseFragment<FragmentRegisterBinding, RegisterPresenter, RegisterView> implements RegisterView {
    @Override
    protected FragmentRegisterBinding binding(LayoutInflater inflater, ViewGroup container) {
        return FragmentRegisterBinding.inflate(inflater, container, false);
    }

    @Override
    protected RegisterPresenter getPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected RegisterView attachView() {
        return this;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initActions() {
        mBinding.tvCreateAccount.setOnClickListener(v -> {
            pushFragment(RegisterFragment.newInstance(RegisterFragment.class));
        });

        mBinding.appToolbar.setListener(this::onBackPressed);
    }
}
