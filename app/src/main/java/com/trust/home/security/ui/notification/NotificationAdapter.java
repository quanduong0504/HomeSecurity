package com.trust.home.security.ui.notification;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.trust.home.security.base.BaseAdapter;
import com.trust.home.security.databinding.ItemNotificationBinding;
import com.trust.home.security.network.data.response.Notification;

public class NotificationAdapter extends BaseAdapter<Notification, ItemNotificationBinding> {
    @Override
    protected void bindView(ItemNotificationBinding binding, Notification itemData, int position) {
        binding.tvStatus.setText(itemData.getStatus());
        binding.tvDate.setText(itemData.getDate());
    }

    @Override
    protected ItemNotificationBinding getViewBinding(LayoutInflater inflater, ViewGroup parent) {
        return ItemNotificationBinding.inflate(inflater, parent, false);
    }
}
