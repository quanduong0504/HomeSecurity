package com.trust.home.security.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionUtils {
    private static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;

    public static boolean isPermissionGranted(Context context) {
        return ContextCompat.checkSelfPermission(context, PERMISSION_CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(Activity activity) {
        if(!isPermissionGranted(activity)) {
            ActivityCompat.requestPermissions(activity, new String[] {PERMISSION_CAMERA}, 1);
        }
    }
}
