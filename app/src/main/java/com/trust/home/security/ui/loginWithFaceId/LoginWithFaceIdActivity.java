package com.trust.home.security.ui.loginWithFaceId;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.trust.home.security.R;
import com.trust.home.security.base.BaseActivity;
import com.trust.home.security.databinding.ActivityLoginWithFaceIdBinding;
import com.trust.home.security.helpers.events.LoginFaceSuccess;
import com.trust.home.security.ui.main.MainActivity;
import com.trust.home.security.utils.AppPrefsManager;
import com.trust.home.security.utils.CameraManager;
import com.trust.home.security.utils.FacialRecognize;

import org.greenrobot.eventbus.EventBus;

public class LoginWithFaceIdActivity
        extends BaseActivity<ActivityLoginWithFaceIdBinding, LoginWithFaceIdPresenter, LoginWithFaceIdView>
        implements LoginWithFaceIdView, CameraManager.CameraListener, FacialRecognize.RecognitionListener {
    @Override
    protected ActivityLoginWithFaceIdBinding binding(LayoutInflater inflater) {
        return ActivityLoginWithFaceIdBinding.inflate(inflater);
    }

    private boolean isFinished = false;

    @Override
    protected LoginWithFaceIdPresenter getPresenter() {
        return new LoginWithFaceIdPresenter();
    }

    @Override
    protected void initViews() {
        CameraManager.initialize(this, mBinding.previewCamera);
        CameraManager.getInstance().setListener(this);
        CameraManager.getInstance().startCamera();
    }

    @Override
    protected void initActions() {

    }

    @Override
    protected LoginWithFaceIdView attachPresenter() {
        return this;
    }

    @Override
    public void onDetectFaceSuccess(Bitmap bitmap) {
        FacialRecognize.getInstance(this).recognize(
                AppPrefsManager.getInstance().getUser().getUserName(),
                bitmap,
                this
        );
    }

    @Override
    public void onDetectFaceFailure() {

    }

    @Override
    public void recognizeSuccess() {
        if(isFinished) return;
        isFinished = true;
        mBinding.icPin.setImageResource(R.drawable.ic_asset_unlock);
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            pushActivityAndFinish(MainActivity.class);
            EventBus.getDefault().postSticky(new LoginFaceSuccess());
        }, 600);
    }

    @Override
    public void recognizeFailure() {

    }

    @Override
    public void userHasNotRegistration() {

    }
}
