package com.example.scriptx1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.logging.Handler;


public class ColorSelectedFloatWindowBig extends BaseFloatWindow {
    private static int FLAGS = 1;
    public static Button button2;
    public static TextView textView;
    public static String[] buttonTitle = {"run...", "run"};


    @SuppressLint("HandlerLeak")
    final static android.os.Handler FloatWindowHandle = new android.os.Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 0x00001:
                    Bundle bundle = msg.getData();
                    bundle.getString("title");
                    button2.setText(bundle.getString("title"));
                    break;
                case 0x000010:
                    break;

            }

        }

    };
    // 构造方法
    ColorSelectedFloatWindowBig(Context context, int resource) {
        super(context, resource);

    }



    @Override
    public void setLayoutParams() {
        super.setLayoutParams();
        WindowManager.LayoutParams lp = getmLayoutParams();
        //int[] windowInfo = getScreenInfo(getmContext());
        lp.width = 150;
        lp.height = 120;
        lp.alpha = 0.95f;
    }

    public static void setButtonStatus(){
        //更改button标题
        FLAGS = 1 - FLAGS;
        if (FLAGS == 0) {
            MainActivity.script.start();//开始脚本
        } else {
            MainActivity.script.finish();//结束脚本
        }
        Message msg = new Message();
        msg.what =0x00001;
        Bundle bundle = new Bundle();
        bundle.putString("title",buttonTitle[FLAGS]);
        msg.setData(bundle);
        FloatWindowHandle.sendMessage(msg);

    }
    @Override
    public void setViewEvent() {
        View view = getmView();
        button2 = view.findViewById(R.id.button2);//开始脚本  或  结束脚本
        textView = view.findViewById(R.id.textView);
        final WindowManager.LayoutParams wmParams = getmLayoutParams();


        //1.实例化java脚本
        //2.设置屏幕方向
        //3.开始或者结束脚本
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (MainActivity.script == null) {
                    Toast.makeText(getmContext(), "请选择一个脚本", Toast.LENGTH_SHORT).show();
                    return;
                }

                //设置屏幕方向
                if (MainActivity.ScreenOrientation == -1){
                    Toast.makeText(getmContext(), "请设置屏幕方向", Toast.LENGTH_SHORT).show();
                    return;
                }

                //启动或结束脚本 设置按钮标题
                ColorSelectedFloatWindowBig.setButtonStatus();



            }
        });




        //拖动悬浮窗
        view.setOnTouchListener(new View.OnTouchListener() {
            float downX = 0;
            float downY = 0;
            int oddOffsetX = 0;
            int oddOffsetY = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downX = event.getX();
                        downY = event.getY();
                        oddOffsetX = wmParams.x;
                        oddOffsetY = wmParams.y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float moveX = event.getX();
                        float moveY = event.getY();
                        //不除以3，拖动的view抖动的有点厉害
                        wmParams.x += (moveX - downX) / 6;
                        wmParams.y += (moveY - downY) / 6;
                        if (getmView() != null) {
                            getmWindowManager().updateViewLayout(getmView(), wmParams);
                        }
                        break;
                }
                return true;
            }
        });
    }
}
