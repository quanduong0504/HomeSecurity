package com.trust.home.security.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trust.home.security.base.BaseAdapter;
import com.trust.home.security.databinding.ItemHomeBinding;
import com.trust.home.security.network.data.response.HomeData;

public class HomeAdapter extends BaseAdapter<HomeData, ItemHomeBinding> {
    @Override
    protected void bindView(ItemHomeBinding binding, HomeData itemData, int position) {
        binding.homeName.setText(itemData.getName());
    }

    @Override
    protected ItemHomeBinding getViewBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemHomeBinding.inflate(inflater, parent, false);
    }
}
