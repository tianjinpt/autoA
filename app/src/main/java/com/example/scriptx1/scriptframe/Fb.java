package com.example.scriptx1.scriptframe;


import android.util.Log;

public class Fb extends F {
    String name;
    Fcallback mCallback;

    public Fb(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
    }

    public Fb(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
    }

    public Fb(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
    }

    public Fb(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public Fb(String name, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.name = name;
    }

    public Fb(String name, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.name = name;

    }

    public Fb(String name, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.name = name;
    }

    public Fb(String name, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.name = name;
    }
    public Fb(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, float xx, float yy){
        super(mainColor, subColor, distance, x1, y1, x2, y2, xx,yy);

    }
    public Fb(String name, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, float xx, float yy){
        super(mainColor, subColor, distance, x1, y1, x2, y2, xx,yy);
        this.name = name;
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public Fb(Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
    }

    public Fb(Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
    }

    public Fb(Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
    }

    public Fb(Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------


    public Fb(String name, Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
    }

    public Fb(String name, Fcallback fcallback, int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
        this.name=name;
    }

    public Fb(String name, Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        super(mainColor, subColor, distance, x1, y1, x2, y2);
        this.mCallback=fcallback;
        this.name=name;
    }

    public Fb(String name, Fcallback fcallback, int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        super(mainColor, subColor, distance, x1, y1, x2, y2, t, r);
        this.mCallback=fcallback;
        this.name=name;
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public void action() throws InterruptedException {
        int[] xy = findColor();
        if (xy!=null){
            if(debug){
                Log.i("找色log-b",String.format("找到【%s】{x=%s,y=%s,z=%s}",name,xy[0], xy[1],xy[2]));
            }

            //有回调 则执行回调 不执行点击操作
            if (mCallback!=null) {
                mCallback.fCallback(xy[0], xy[1],getT(),getR());
            }else{
                click(xy[0],xy[1],getT(),getR());
                if(debug){
                    Log.i("点击log-b",String.format("点击【%s】{x=%s,y=%s,z=%s}",name,xy[0], xy[1],xy[2]));
                }
            }
        }


    }


}
