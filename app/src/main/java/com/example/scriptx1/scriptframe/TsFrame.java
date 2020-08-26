package com.example.scriptx1.scriptframe;

import java.util.List;
import java.util.Map;

public abstract class TsFrame {

    private List<Fa> mFa;
    private Map<String, List<Fb>> mFb;
    private int flag = 0;
    private List<Fb> subFb;

    public TsFrame() {
        this.mFa = getFa();
        this.mFb = getFb();

    }

    public int getFlag() {
        return flag;
    }

    protected abstract List<Fa> getFa();

    public abstract Map<String, List<Fb>> getFb();


    //脚本逻辑（页面）
    private void body() throws InterruptedException {

        //Fa和Fb只要有回调 就不往下执行
        //Fa有name则根据name获取Fb的list  无name则直接点击
        //Fb有无name都点击

        for (Fa fa : mFa) {
            if (flag == 0) {
                return;
            }

            subFb = fa.action(mFb);//页面操作

            if (subFb != null) {//子页面操作
                for (Fb fb : subFb) {
                    if (flag == 0) {
                        return;
                    }
                    fb.action();
                }
            }
        }

        if (flag == 1) {
            body();
        }
    }

    //启动脚本
    public void start() {
        if (flag == 0) {
            flag = 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        body();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    //结束脚本
    public void finish() {
        flag = 0;
    }


}
