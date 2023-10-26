package com.trust.home.security.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.trust.home.security.base.BaseCustomView;
import com.trust.home.security.databinding.LayoutUserToolbarBinding;

public class UserToolBar extends BaseCustomView<LayoutUserToolbarBinding> {
    public UserToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected LayoutUserToolbarBinding getBinding(LayoutInflater inflater, ViewGroup viewGroup) {
        return LayoutUserToolbarBinding.inflate(inflater, viewGroup, true);
    }

    @Override
    protected void initViews(Context context, AttributeSet attrs) {

    }

    @Override
    protected void initActions() {

    }
}
