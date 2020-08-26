package com.example.scriptx1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.graphics.Path;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;


public class MyAccessibilityService extends AccessibilityService {
    public static final boolean F = false;
    public static final String ACTION = "action";
    public static final String CLICK = "click";
    public static final String NODE_CLICK_M = "node_click";
    public static final String SLIDE = "slide";
//    public static final Path mPath = new Path();
    public AccessibilityNodeInfo ParentNode;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getStringExtra(ACTION);
            if (action != null) {
                if (CLICK.equals(action)) {
                    // 点击屏幕
                    screenClick(intent.getIntExtra("x", -1), intent.getIntExtra("y", -1));
                } else if (SLIDE.equals(action)) {
                    //屏幕滑动
                    screenSlide(intent.getIntExtra("x", -1),
                            intent.getIntExtra("y", -1),
                            intent.getIntExtra("x2", -1),
                            intent.getIntExtra("y2", -1));
                }
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        ParentNode = getRootInActiveWindow();
//        if (ParentNode != null) {
//                List<AccessibilityNodeInfo> nodeInfoList2 = ParentNode.findAccessibilityNodeInfosByText("赞");
//                if (!nodeInfoList2.isEmpty()){
//                    for (AccessibilityNodeInfo nod:nodeInfoList2) {
//                        nod.performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                    }
//
//                }
//
//            }
//

    }


    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.i("ADT", "服务开启了！！");
    }

    @Override
    public void onInterrupt() {
    }

    public void screenClick(float x, float y) {//屏幕点击
        Path mPath = new Path();
        mPath.moveTo(x, y);
        try {
            dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription
                    (mPath, 0, 100)).build(), null, null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void screenSlide(float x, float y,float x2, float y2) {//屏幕滑动
//        Path mPath = new Path();
//        mPath.moveTo(x, y);
//        mPath.lineTo(x2, y2);
//        try {
//            dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription
//                    (mPath, 0, 500)).build(), null, null);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        if (x!=-1){
            Path mPath = new Path();
            mPath.moveTo(x, y);
            mPath.lineTo(x2, y2);

                dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription
                        (mPath, 0, 500)).build(), null, null);

        }

    }

    public void nodeClickText(String nodeText, int count, int item) {//节点点击
            ParentNode = getRootInActiveWindow();

            if (ParentNode != null) {

                List<AccessibilityNodeInfo> nodeInfoList = ParentNode.findAccessibilityNodeInfosByText("次赞");

                if (!nodeInfoList.isEmpty()) {

                    if (item == -1) { //所有节点都点击count次数
                        for (AccessibilityNodeInfo a : nodeInfoList) {
                            for (int i = 0; i < count; i++) {
                                a.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            }
                        }
                    } else {  //item节点都点击count次数
                        nodeInfoList.get(item).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    }
                }
            }

    }


}
