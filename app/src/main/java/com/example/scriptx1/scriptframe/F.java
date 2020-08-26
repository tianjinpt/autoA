package com.example.scriptx1.scriptframe;

import com.example.scriptx1.screendo.GBData;
import com.example.scriptx1.screendo.ScreenLib;

import java.util.ArrayList;

import static com.example.scriptx1.screendo.GBData.color16To10_int;


public abstract class F extends ScreenLib {
    private int mainColor; //主颜色
    private String subColor; //子颜色
    private double distance; //相似度
    private int x1, y1, x2, y2; //找色范围
    private double x1d, y1d, x2d, y2d; //找色范围
    private int t = 800; //延迟
    private int r = 10; //随机范围
    private int flag;//0为浮点参数构造，1为整数参数构造
    private float xx,yy;

    private ArrayList<Integer[]> analysisSubColor;
    private int[] analysisMainColor;
    public String name = "未命名";
    public boolean debug = true;

    public int getT() {
        return t;
    }

    public int getR() {
        return r;
    }

    public F(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.flag=1;
        analysis();
    }

    public F(int mainColor, String subColor, double distance, int x1, int y1, int x2, int y2, int t, int r) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.t = t;
        this.r = r;
        this.flag=1;
        analysis();
    }
    public F(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1d = x1;
        this.y1d = y1;
        this.x2d = x2;
        this.y2d = y2;
        this.flag=0;
        analysis();
    }

    public F(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, int t, int r) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1d = x1;
        this.y1d = y1;
        this.x2d = x2;
        this.y2d = y2;
        this.t = t;
        this.r = r;
        this.flag=0;
        analysis();
    }

    public F(int mainColor, String subColor, double distance, double x1, double y1, double x2, double y2, float xx, float yy) {
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.distance = distance;
        this.x1d = x1;
        this.y1d = y1;
        this.x2d = x2;
        this.y2d = y2;
        this.xx = xx;
        this.yy = yy;
        this.flag=0;
        analysis();
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    //解析文本参数
    private void analysis(){
        analysisSubColor = GBData.getColorListSub(subColor);//16进制文本颜色转成10进制颜色数组（子颜色列表）
        analysisMainColor = color16To10_int(mainColor);//文本转10进制颜色（主颜色）
    }
    public int[] click() throws InterruptedException {
        if (flag==1){
            //findColorClick(mainColor,subColor,distance,x1,y1,x2,y2,t,r);
            return findColorClick(analysisMainColor,analysisSubColor,distance,x1,y1,x2,y2,t,r,(int) xx,(int) yy);
        }else if (flag==0){
            //findColorClick(mainColor,subColor,distance,x1d,y1d,x2d,y2d,t,r);
            return findColorClick(analysisMainColor,analysisSubColor,distance,x1d,y1d,x2d,y2d,t,r,(int) xx,(int) yy);
        }
        return null;
    }

    public int[] findColor() throws InterruptedException {
        if (flag==1){
            return findColor(analysisMainColor,analysisSubColor,distance,x1,y1,x2,y2);
        }else if (flag==0){
            return findColor(analysisMainColor,analysisSubColor,distance,x1d,y1d,x2d,y2d);
        }
        return null;
    }



}
