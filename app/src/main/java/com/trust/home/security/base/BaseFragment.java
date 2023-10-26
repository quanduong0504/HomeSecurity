package com.trust.home.security.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;

import com.trust.home.security.helpers.GenericsClassType;
import com.trust.home.security.widgets.DialogMessage;

public abstract class BaseFragment<BD extends ViewBinding, P extends BasePresenter<V>, V extends BaseView> extends Fragment implements BaseView {
    protected BaseActivity<?, ?, ?> baseActivity;
    protected abstract BD binding(LayoutInflater inflater, ViewGroup container);
    protected abstract P getPresenter();
    protected BD mBinding;
    protected P mPresenter;

    @Override
    public void onStart() {
        super.onStart();
        baseActivity = (BaseActivity<?, ?, ?>) getContext();
    }

    public static <T extends BaseFragment<?, ?, ?>> T newInstance(Class<T> clz) {
        try {
            return clz.newInstance();
        } catch (IllegalAccessException | java.lang.InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends BaseFragment<?, ?, ?>> T newInstance(Class<T> clz, Bundle args) {
        T fragment = T.newInstance(clz);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showLoading() {
        baseActivity.showLoading();
    }

    @Override
    public void hideLoading() {
        baseActivity.hideLoading();
    }

    protected abstract void initViews();
    protected abstract void initActions();
    protected abstract V attachView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = binding(inflater, container);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = getPresenter();
        mPresenter.onAttach(attachView());
        initViews();
        initActions();
    }

    protected void pushFragment(Fragment fragment) {
        baseActivity.pushFragment(fragment);
    }
    protected void showDialogMessage(String message, DialogMessage.DialogMessageListener listener) {
        baseActivity.showDialogMessage(message, listener);
    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }

    @Override
    public void onError(String message) {
        baseActivity.onError(message);
    }

    @Override
    public void onError(Exception exception) {
        baseActivity.onError(exception);
    }

    protected void onBackPressed() {
        baseActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        hideKeyboard();
    }

    protected void hideKeyboard() {
        baseActivity.hideKeyboard();
    }
}
