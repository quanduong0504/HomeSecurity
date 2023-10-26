package com.trust.home.security.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.trust.home.security.R;
import com.trust.home.security.base.BaseCustomView;
import com.trust.home.security.databinding.LayoutAppToolbarBinding;

public class AppToolBar extends BaseCustomView<LayoutAppToolbarBinding> {
    private AppToolbarListener listener;

    public void setListener(AppToolbarListener listener) {
        this.listener = listener;
    }

    public AppToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected LayoutAppToolbarBinding getBinding(LayoutInflater inflater, ViewGroup viewGroup) {
        return LayoutAppToolbarBinding.inflate(inflater, viewGroup, true);
    }

    @Override
    protected void initViews(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AppToolBar);
        String title = typedArray.getString(R.styleable.AppToolBar_atb_title);
        typedArray.recycle();
        mBinding.tvTitle.setText(title);
    }

    @Override
    protected void initActions() {
        mBinding.imBack.setOnClickListener(v -> {
            if(listener != null) {
                listener.onBackPress();
            }
        });
    }

    public interface AppToolbarListener {
        void onBackPress();
    }
}
