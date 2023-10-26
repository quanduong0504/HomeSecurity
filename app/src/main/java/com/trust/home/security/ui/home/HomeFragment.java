package com.trust.home.security.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trust.home.security.base.BaseFragment;
import com.trust.home.security.databinding.FragmentHomeBinding;
import com.trust.home.security.network.data.response.HomeData;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomePresenter, HomeView> implements HomeView {
    private HomeAdapter mAdapter;

    @Override
    protected FragmentHomeBinding binding(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    protected HomeView attachView() {
        return this;
    }

    @Override
    protected void initViews() {
        mAdapter = new HomeAdapter();
        mBinding.rvHomes.setAdapter(mAdapter);
        mAdapter.setData(
                new HomeData("Marvel House"),
                new HomeData("Add a new house")
        );
    }

    @Override
    protected void initActions() {

    }
}
