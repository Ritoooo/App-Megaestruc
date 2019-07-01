package com.megaestruc.megaestruc_app.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class BasePresenter {
    protected BasePresenter(){}
    @CallSuper
    void onCreate(@Nullable final Bundle savedInstanceState){}
    @CallSuper
    void onResume(){}
    @CallSuper
    void onPause(){}
    @CallSuper
    void onSaveInstanceState(@NonNull final Bundle outState){}
    @CallSuper
    void onDestroy(){}
    @CallSuper
    void onActivityResult(final int requestCode, final int resultado, @Nullable final Intent data){}
    @CallSuper
    void onRequestPermissionResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults){}
}
