package com.example.scriptx1;

import android.os.Bundle;
import android.os.Message;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.Fa;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyScript extends TsFrame {
    private static MyScript myScript=null;

    private MyScript(){
    }

    public static MyScript getInstance(){
        if (myScript==null){
            myScript = new MyScript();
        }
        return myScript;
    }
    //试炼按钮 回调函数（找到颜色才会执行）
    public class shilian implements Fcallback {
        private int i;

        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            i++;
            ScreenLib.click(x, y, t, r);
            Message msg = new Message();
            msg.what = 0x00001;
            Bundle bundle = new Bundle();
            bundle.putString("key", "试炼按钮" + i);
            msg.setData(bundle);
            MainActivity.MainHandler.sendMessage(msg);
            //Toast.makeText(MainActivity.CONTEXT, "试炼按钮", Toast.LENGTH_SHORT).show();

        }
    }

    public class 胜利s implements Fcallback {

        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {

        }
    }

    @Override
    protected List<Fa> getFa() {
        List<Fa> fa = new ArrayList<Fa>();//页面特征
        fa.add(new Fa("试炼界面", 0xb4afad, "-63|-32|0x8b0714,48|37|0xc12816,-57|41|0xdd381d,50|-21|0x7a0810,-95|0|0xfbf0d2", 90, 0.24, 0.84, 0.73, 0.95));

        fa.add(new Fa(new shilian(), 0xb4afad,//"试炼"
                "-54|-21|0x7a0810,47|-29|0x910416,-49|38|0xda361d,42|26|0xc72a17",
                50, 0.28, 0.80, 0.99, 0.98, 300, 11));



        fa.add(new Fa(0xe9f5df,//"布阵进攻",
                "19|24|0x4f9413,41|19|0xdfedd4,41|-2|0x5a8f41,85|7|0xf6ffec,104|15|0xdeecd3,142|18|0x458227,149|-6|0xf6ffec",
                90, 0.39, 0.68, 0.62, 0.80, 300, 11));

        fa.add(new Fa(0x62a21a, "-12|7|0xaac69d,-13|19|0x4e8d25,-2|9|0xf6ffec,-13|-13|0x6d9d54,-29|-7|0xf6ffec,-35|7|0xaac69d",//"开战2",
                90, 0.47, 0.48, 0.55, 0.50));

        fa.add(new Fa("胜利界面",  0xf6454d, "171|18|0xdd6420,349|41|0xf8e644", 90, 0.07, 0.23, 0.14, 0.43));
        fa.add(new Fa("失败界面",  0x3b6cae,"-96|-49|0x4d6071,57|-16|0x3c71c1,323|-139|0xb69470",90,0.16,0.24,0.22,0.46));



        return fa;
    }

    @Override
    public Map<String, List<Fb>> getFb() {
        Map<String, List<Fb>> map = new HashMap<String, List<Fb>>();
        List<Fb> 试炼界面 = new ArrayList<Fb>();//试炼 页面
        试炼界面.add(new Fb("开战1", 0xf4ffe8,
                "0|5|0x6cb22b,-1|14|0xf4ffea,-7|8|0xf4ffe8,8|8|0xcee4be,19|8|0x68b31b,-23|6|0x6ab51c,-4|34|0x499a0f,-3|-16|0x7bc822",
                90, 0.81, 0.22, 0.84, 0.58, 300, 11));

        List<Fb> 胜利界面 = new ArrayList<Fb>();//试炼 页面
        胜利界面.add(new Fb("点击下一层",0xfffeea,"31|2|0xdfc59c,125|1|0xfffeea,177|5|0xebddc0,176|-18|0xedc33b,176|-18|0xedc33b",90,0.57,0.64,0.63,0.82));
        胜利界面.add(new Fb("胜利确认(中间位置)",0xf6ffec,"24|2|0xc4dab6,96|-10|0xf6ffec,96|24|0xf6ffec,-29|10|0x5eac18,167|19|0x5ba917",90,0.34,0.64,0.51,0.81));
        //胜利界面.add(new Fb("胜利确认",0x9dc08a, "-11|-13|0x619449,-2|6|0x468423,6|-25|0xf2fbe6,42|-13|0x61ad19,74|-34|0xf6ffec,77|6|0xf6ffec,56|9|0xbcd2ab", 90, 0.40, 0.71, 0.61, 0.83));

        List<Fb> 失败界面 = new ArrayList<Fb>();//试炼 页面
        失败界面.add(new Fb("重新挑战",0xfffeea,"18|3|0xcfad7a,69|12|0xa86400,122|15|0xfffeea,159|6|0xc9a165,74|-33|0xefce41",90,0.57,0.65,0.67,0.80));
        失败界面.add(new Fb("失败确认(左边位置)",0x9dc08a, "-11|-13|0x619449,-2|6|0x468423,6|-25|0xf2fbe6,42|-13|0x61ad19,74|-34|0xf6ffec,77|6|0xf6ffec,56|9|0xbcd2ab", 90, 0.40, 0.71, 0.61, 0.83));


        map.put("试炼界面", 试炼界面);
        map.put("胜利界面", 胜利界面);
        map.put("失败界面", 失败界面);
        return map;
    }
}
