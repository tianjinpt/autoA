package com.example.scriptx1.scriptframe;

import android.util.Log;

import java.util.List;
import java.util.Map;

public class Fa extends F {
    Fcallback mCallback;
    String name = "未命名";

    public Fa(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
    }

    public Fa(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
    }

    public Fa(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
    }

    public Fa(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public Fa(String name, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.name = name;
    }

    public Fa(String name, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.name = name;

    }

    public Fa(String name, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.name = name;
    }

    public Fa(String name, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.name = name;
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public Fa(Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
    }

    public Fa(Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
    }

    public Fa(Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
    }

    public Fa(Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------


    public Fa(String name, Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
    }

    public Fa(String name, Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
        this.name=name;
    }

    public Fa(String name, Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
        this.name=name;
    }

    public Fa(String name, Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
        this.name=name;
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------


    public List<Fb> action(Map<String,List<Fb>> fb) throws InterruptedException {
        int[] xy = findColor();
        if (xy!=null){
            if(debug){
                Log.i("找色log-a",String.format("找到【%s】{x=%s,y=%s,z=%s}",name,xy[0], xy[1],xy[2]));
            }
            //有回调不往下执行
            if (mCallback!=null) {
                mCallback.fCallback(xy[0], xy[1],getT(),getR());
            }else{


                if (!name.equals("未命名")){ //返回 name对应的 List<Fb>
                    try{
                        return fb.get(name);
                    }catch (Exception e){
                        return null;
                    }

                }else{ //点击
                    click(xy[0], xy[1],getT(),getR());
                    if(debug){
                        Log.i("点击log-a",String.format("点击【%s】{x=%s,y=%s,z=%s}",name,xy[0], xy[1],xy[2]));
                    }
                }
            }


        }
        return null;

    }


}
