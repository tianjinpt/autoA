package com.example.scriptx1;

import android.util.Log;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.Fa;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptWzRy extends TsFrame {

    private static ScriptWzRy instance=null;
    private ScriptWzRy(){}
    public static ScriptWzRy getInstance(){
        if (instance==null){
            instance = new ScriptWzRy();
        }
        return instance;
    }

    @Override
    protected List<Fa> getFa() {
        List<Fa> fa= new ArrayList<Fa>();
        //主界面
        fa.add(new Fa("主界面",0xfad667,"-30|-11|0xfffcf4,-13|-5|0xe4b389,-4|2|0xf9dc62",90,0.81,0.82,1.0,01.00));
        fa.add(new Fa(new 万象天工界面(),0x7896c1,"-2|-10|0x7e9cc7,18|-5|0x6d8cb7,12|6|0x3b5c82,8|-4|0x1e3f63,15|-10|0x1e3f63",90,0.03,0.10,0.12,0.16));
        //冒险界面  点击挑战
        fa.add(new Fa(0x0b66c0,"-5|-64|0xb5d6e7,11|354|0x8a92e5,-209|149|0x374861,207|151|0x4788c1,-573|188|0xe39868,-460|164|0x13a2e6",90,0.45,0.27,0.56,0.39));
        fa.add(new Fa("挑战界面",new 挑战界面(),0x02bfff,"-32|12|0x02bfff,2|800|0x02a8d7,28|785|0x02a8d7",90,0.18,0.15,0.33,0.20));
        //闯关按钮
        fa.add(new Fa(0xffffff,"66|-3|0xf0ece5,81|-18|0x876738,68|-7|0xffffff,-382|25|0x2b6596,-166|-515|0x08b110",90,0.65,0.76,0.84,0.86));

        //跳过按钮
        fa.add(new Fa(0xa2b9cc,"33|-12|0xc7dbe9,-19|-4|0x153657,70|-2|0x153657",90,0.92,0.01,0.99,0.08));

        //点击屏幕继续
        fa.add(new Fa(0xd08612,"83|-50|0x713109,-58|-47|0xd6a41c,10|-92|0xf1dd64,-95|-34|0x325b9d",90,0.32,0.28,0.46,0.39));


        //再次挑战按钮
        fa.add(new Fa(0xf8eed8,"22|-13|0xfbf3dd,51|7|0xfbf3dd,-32|-34|0x785f36,-332|-26|0x24557f,-203|-15|0x2b5c85",90,0.76,0.86,0.95,0.98));
        return fa;
    }

    @Override
    public Map<String, List<Fb>> getFb() {

        Map<String, List<Fb>> map = new HashMap<String, List<Fb>>();
        List<Fb> 主界面= new ArrayList<Fb>();
        主界面.add(new Fb(0xcaddef,"12|-2|0xabcde6,26|0|0x93b4ce,0|28|0x8697c9,22|31|0xe2e7f0,11|22|0xd4e3f7,10|9|0xdaedff",140,0.76,0.68,0.87,0.78));


        map.put("主界面",主界面);
        return map;
    }
    class 万象天工界面 implements Fcallback{

        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            //冒险模式
            int[] i = ScreenLib.findColorClick(0xdef1f8,"32|-7|0xb7e2f5,210|-519|0x696e32,155|-446|0x515934,50|-2|0xa4d2e4,211|-2|0xc4e8f5,241|1|0xf7fbfa",60,0.15,0.71,0.99,0.85);
            if (i==null){
                ScreenLib.screenSlide(1357,561,990,572);

            }

        }
    }

    class 挑战界面 implements Fcallback{

        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            //点击魔种巢穴
            ScreenLib.findColorClick(0xdde7f1, "57|0|0xe4e7f0,64|-1|0xe2e6f1,70|-1|0xf7feff,64|-2|0xd8dce7,61|6|0xe2e9f1,67|4|0xe3e7f3,64|-15|0x39496b", 120,0.52,0.19,0.63,0.59);
            //选中的魔种巢穴
            int[] i = ScreenLib.findColorClick(0xfff3f2, "58|0|0xf3e0e4,64|-1|0xfff3f6,70|-1|0xfff1f7,67|4|0xffeef6,61|5|0xffedf1,61|-13|0x66141a", 120,0.52,0.20,0.64,0.57);
            if (i==null){
                //下一个关卡
                ScreenLib.findColorClick(0x02bfff,"-29|-13|0x02bfff,26|-16|0x02bfff",90,0.18,0.86,0.31,0.94);
            }else{
                //下一页 按钮
                ScreenLib.findColorClick(0xddeffb,"40|-6|0x245b85,-58|-8|0x265983,143|-5|0x235c86",90,0.70,0.79,0.86,0.90);
            }

        }
    }
}
