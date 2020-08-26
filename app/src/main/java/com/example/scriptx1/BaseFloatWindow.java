package com.example.scriptx1;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;


public abstract class BaseFloatWindow {
    private Context mContext;
    private WindowManager mWindowManager;
    private boolean isShow = false;
    private View mView;
    public WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();

    private View setView(int resource) {
        return LayoutInflater.from(getmContext()).inflate(resource, null);
    }

    public void setViewEvent() {
        //设置布局文件下 控件的事件
        //
        //View v = getmView();
    }

    BaseFloatWindow(Context context, int resource) {
        mContext = context.getApplicationContext();//上下文
        mView = setView(resource);//创建要显示的浮动窗口视图
        setViewEvent();//绑定事件
        setLayoutParams();//布局参数
    }

    BaseFloatWindow(Context context, int resource, BaseFloatWindow bfw) {
        mContext = context.getApplicationContext();//上下文
        mView = setView(resource);//创建要显示的浮动窗口视图
        setViewEvent();//绑定事件
        setLayoutParams();//布局参数
    }

    void floatWindowShow() {//显示浮动窗口
        if (isShow) {
            return;
        }
        isShow = true;
        mContext.getApplicationContext();
        mWindowManager = (WindowManager) mContext.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        assert mWindowManager != null;
        //判断悬浮窗权限
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Settings.canDrawOverlays(mContext)) {
                MainActivity.bu.show();//悬浮窗对话框
            } else {
                //Android6.0以上
                mWindowManager.addView(mView, mLayoutParams);
            }
        }
    }

    void floatWindowHide() {//隐藏浮动窗口
        if (isShow && mView != null) {
            try {
                mWindowManager.removeView(mView);
                isShow = false;
            }catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }




    public void setLayoutParams() {//布局参数
        assert mLayoutParams != null;
        if (Build.VERSION.SDK_INT < 26) {//适配安卓8之前的悬浮窗
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        } else {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
//        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        mLayoutParams.flags =WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM | WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        mLayoutParams.format = PixelFormat.RGBA_8888;
        assert mContext != null;

//        mLayoutParams.width = 500;
//        mLayoutParams.height = 500;
        mLayoutParams.alpha = 1f;
        mLayoutParams.gravity = Gravity.CENTER | Gravity.TOP;
        mLayoutParams.x = 0;
        mLayoutParams.y = 100;
    }

    public boolean isShoew() {
        return isShow;
    }

    View getmView() {
        return mView;
    }

    Context getmContext() {
        return mContext;
    }

    WindowManager.LayoutParams getmLayoutParams() {
        return mLayoutParams;
    }

    public WindowManager getmWindowManager() {
        return mWindowManager;
    }
}
