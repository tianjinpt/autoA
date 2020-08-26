package com.example.scriptx1.screendo;

import android.content.Intent;

import com.example.scriptx1.MainActivity;
import com.example.scriptx1.MyAccessibilityService;
import com.example.scriptx1.scriptframe.Fa;
import com.example.scriptx1.scriptframe.Fb;

import java.util.ArrayList;

public class ScreenLib {
    private static int times=500;
    //取随机数
    private static int getRandom(int start,int end){
        return (int) (Math.random()*(end-start+1)+start);
    }
    //延时
    public static void sleep(int sle) throws InterruptedException {
        Thread.sleep(sle);
    }
    public int[] findColor(Fa fa) throws InterruptedException {
        return fa.findColor();
    }
    public int[] findColor(Fb fb) throws InterruptedException {
        return fb.findColor();
    }

    public void click(Fa fa) throws InterruptedException {
        fa.click();
    }
    public void click(Fb fb) throws InterruptedException {
        fb.click();
    }

    //屏幕滑动
    public static void screenSlide(int x, int y, int x2, int y2) throws InterruptedException {
        Intent intent = new Intent(MainActivity.CONTEXT, MyAccessibilityService.class);
        intent.putExtra(MyAccessibilityService.ACTION, MyAccessibilityService.SLIDE);//滑动操作
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        intent.putExtra("x2", x2);
        intent.putExtra("y2", y2);
        MainActivity.CONTEXT.startService(intent);
        sleep(600);

    }
    //屏幕滑动 百分比
    public static void screenSlide(double x, double y, double x2, double y2) {
        Intent intent = new Intent(MainActivity.CONTEXT, MyAccessibilityService.class);
        intent.putExtra(MyAccessibilityService.ACTION, MyAccessibilityService.SLIDE);//滑动操作
        intent.putExtra("x", (int)(x*MainActivity.w));
        intent.putExtra("y", (int)(y*MainActivity.h));
        intent.putExtra("x2", (int)(x2*MainActivity.w));
        intent.putExtra("y2", (int)(y2*MainActivity.h));
        MainActivity.CONTEXT.startService(intent);

    }
    //点击屏幕
    public synchronized static void click(int x, int y) {
        Intent intent = new Intent(MainActivity.CONTEXT, MyAccessibilityService.class);
        intent.putExtra(MyAccessibilityService.ACTION, MyAccessibilityService.CLICK);//点击操作
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        MainActivity.CONTEXT.startService(intent);

    }
    //点击屏幕 点击范围
    public static void click(int x, int y, int r) {
        x=getRandom(x-r,x+r);
        y=getRandom(y-r,y+r);
        click(x,y);
    }


    //点击屏幕 延时
    public static void click(int x, int y, float t) throws InterruptedException {
        click(x,y);
        sleep((int)t);
    }


    //点击屏幕 范围 延时
    public static void click(int x, int y, float t,int r) throws InterruptedException {
        x=getRandom(x-r,x+r);
        y=getRandom(y-r,y+r);
        click(x,y,t);

    }

    //多点找色
    public static int[] findColor(int mainColor, String subColors, double distance, int x1, int y1, int x2, int y2) {
        GBData.getImageBitmap();
        return GBData.MultiPointFindColor(mainColor, subColors, distance, x1, y1, x2, y2);
    }
    //多点找色（优化）
    public static int[] findColor(int[] mainColor, ArrayList<Integer[]> subColors, double distance, int x1, int y1, int x2, int y2) {
        GBData.getImageBitmap();
        return GBData.MultiPointFindColor(mainColor, subColors, distance, x1, y1, x2, y2);
    }
    //百分比找色范围
    public static int[] findColor(int mainColor, String subColors, double distance, double x1, double y1, double x2, double y2) {
        return findColor(mainColor, subColors, distance, (int)(x1*MainActivity.w), (int)(y1*MainActivity.h), (int)(x2*MainActivity.w), (int)(y2*MainActivity.h));
    }
    //百分比找色范围（优化）
    public static int[] findColor(int[] mainColor, ArrayList<Integer[]> subColors, double distance, double x1, double y1, double x2, double y2) {
        return findColor(mainColor, subColors, distance, (int)(x1*MainActivity.w), (int)(y1*MainActivity.h), (int)(x2*MainActivity.w), (int)(y2*MainActivity.h));
    }



    //多点找色点击 默认延迟500毫秒
    public static int[] findColorClick(int mainColor, String subColors, double distance, int x1, int y1, int x2, int y2) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)times);
            return xy;
        }
        return null;
    }
    //多点找色点击
    public static int[] findColorClick(int mainColor, String subColors, double distance, int x1, int y1, int x2, int y2,int time) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)time);

            return xy;
        }
        return null;
    }
    //多点找色点击 范围点击
    public static int[] findColorClick(int mainColor, String subColors, double distance, int x1, int y1, int x2, int y2,int time,int r) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)time,r);

            return xy;
        }
        return null;
    }


    //多点找色点击2 百分比 默认延迟500
    public static int[] findColorClick(int mainColor, String subColors, double distance, double x1, double y1, double x2, double y2) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)times);
            return xy;
        }
        return null;
    }

    //多点找色点击2 百分比
    public static int[] findColorClick(int mainColor, String subColors, double distance, double x1, double y1, double x2, double y2, int time) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)time);
            return xy;
        }
        return null;
    }

    //多点找色点击 范围点击
    public static int[] findColorClick(int mainColor, String subColors, double distance, double x1, double y1, double x2, double y2, int time, int r) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)time,r);
            return xy;
        }
        return null;
    }


    //多点找色点击 范围点击(优化)
    public static int[] findColorClick(int[] mainColor, ArrayList<Integer[]> subColors, double distance, double x1, double y1, double x2, double y2, int time, int r) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)time,r);
            return xy;
        }
        return null;
    }
    //多点找色点击 范围点击(优化)
    public static int[] findColorClick(int[] mainColor, ArrayList<Integer[]> subColors, double distance, double x1, double y1, double x2, double y2, int time, int r,int xx, int yy) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0]+xx,xy[1]+yy,(float)time,r);
            return xy;
        }
        return null;
    }
    //多点找色点击 范围点击（优化）
    public static int[] findColorClick(int[] mainColor, ArrayList<Integer[]> subColors, double distance, int x1, int y1, int x2, int y2,int time,int r) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0],xy[1],(float)time,r);
            return xy;
        }
        return null;
    }


    //多点找色点击 范围点击（优化）x，y偏移
    public static int[] findColorClick(int[] mainColor, ArrayList<Integer[]> subColors, double distance, int x1, int y1, int x2, int y2,int time,int r, int xx, int yy) throws InterruptedException {
        int[] xy = findColor(mainColor, subColors, distance, x1, y1, x2, y2);
        if (xy != null) {
            click(xy[0]+xx,xy[1]+yy,(float)time,r);
            return xy;
        }
        return null;
    }
}