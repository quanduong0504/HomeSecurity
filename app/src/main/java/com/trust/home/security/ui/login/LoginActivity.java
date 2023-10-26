package com.trust.home.security.ui.login;

import android.view.LayoutInflater;

import androidx.viewbinding.ViewBinding;

import com.trust.home.security.R;
import com.trust.home.security.base.BaseActivity;
import com.trust.home.security.databinding.ActivityLoginBinding;
import com.trust.home.security.ui.main.MainActivity;
import com.trust.home.security.ui.register.RegisterFragment;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginPresenter, LoginView> implements LoginView {
    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected ActivityLoginBinding binding(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected LoginView attachPresenter() {
        return this;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initActions() {
        mBinding.tvSignIn.setOnClickListener(v -> {
            String username = mBinding.edtUsername.getText().toString().trim();
            String password = mBinding.inputPassword.getPassword();

            mPresenter.login(username, password);
        });

        mBinding.tvRegister.setOnClickListener(v -> {
            pushFragment(RegisterFragment.newInstance(RegisterFragment.class));
        });
    }

    @Override
    public void onLoginSuccess() {
        pushActivityAndFinish(MainActivity.class);
    }
}
