package com.hoangson.baseandroid.core.bases;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.hoangson.baseandroid.R;

public abstract class BaseDialog extends Dialog {
    public BaseDialog(Context context) {
        super(context, R.style.Theme_IMS_Dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = getWidth();
            params.height = getHeight();
            params.gravity = Gravity.CENTER;
            window.setAttributes(params);
        }
    }

    protected int getWidth() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
        //return ThemeUtils.getScreenWidth(mOwnerActivity) * 8 / 10;
    }

    protected int getHeight() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }

    protected abstract int getLayout();
}
