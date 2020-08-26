package com.example.scriptx1;

import android.annotation.SuppressLint;
import android.widget.Toast;

import com.example.scriptx1.screendo.ScreenLib;
import com.example.scriptx1.scriptframe.Fa;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.Fcallback;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptZdZk extends TsFrame {

    private int slideCunt = 0;// 记录滑动次数
    private boolean 已清空队伍; //几率是否清空队伍;
    private static ScriptZdZk instance = null;
    private ScriptZdZk(){};
    public static ScriptZdZk getInstance(){
        if (instance==null){
            instance = new ScriptZdZk();
        }
        return instance;
    }
    //Fa只用做定义界面（不点击操作）   Fb定义界面要点击的内容
    static boolean 找到大矿 = false;
    static boolean 找到中矿 = false;
    static boolean 找到小矿 = false;
    static boolean 可占领被点击 = false;
    static String 当前队伍 = null;
    static Fa 大矿 = new Fa("大矿", 0x196076, "-16|-6|0x1b708f,16|-2|0x2585ab,-5|-30|0x06c7e8", 60, 0.00, 0.57, 0.07, 0.81);
    static Fa 中矿 = new Fa("中矿", 0x410893, "-17|7|0x5d1c92,12|6|0x290f58,-5|4|0x8629f6", 60, 0.00, 0.57, 0.07, 0.81);
    static Fa 小矿 = new Fa("小矿", 0xe5c74d, "-25|-10|0xd4c55c,19|-15|0x674215,-7|-9|0xf8be50", 60, 0.00, 0.57, 0.07, 0.81);
    static Fa 进入好友列表图标 = new Fa("进入好友列表图标", 0xf9c13a, "19|1|0xf9c13a,-21|-10|0x3f2018,52|-16|0x3f2018,26|-25|0x422319,4|17|0x2f1813", 10, 0.85, 0.70, 0.97, 0.94);
    static Fa 可领取_黄色 = new Fa("可领取_黄色", 0xd2902c, "36|17|0xdd870c,68|13|0xfac10f,25|15|0x861602", 70, 0.09, 0.59, 0.23, 0.83);
    //    static Fa new Fa("恭喜获得界面",);
    //直接点击
    static Fa NPC胡来来 = new Fa(0x7d422c, "16|17|0x7d422c,35|-6|0x7d422c,35|11|0x7d422c,51|6|0xa9806c,63|-4|0x7d422c,73|18|0xaf8a77", 30, 0.08, 0.27, 0.20, 0.56);
    static Fa 恭喜获得=new Fa(0xcf6126, "64|-45|0xdd6320,98|-133|0xfee844,140|-139|0xf8f558", 90, 115, 714, 375, 908);


    static Fb 左滑翻页 = new Fb("左滑翻页", 0xcdb44a, "13|-19|0xcfc357,2|-29|0xd3c757", 90, 0.90, 0.71, 0.99, 0.94, (float) -20, (float) 0);
    static Fb 可占领 = new Fb("可占领", 0x98f127, "19|3|0x93e624,14|2|0x98f127,14|-17|0x98f127,16|-19|0x98f127", 90, 0.63, 0.60, 0.82, 0.79);
    static Fb 占矿布阵防守按钮 = new Fb("占矿布阵防守按钮", 0x75c120, "0|69|0x4f9c12,-98|40|0xa03a09,64|71|0x4c9811", 90, 0.34, 0.76, 0.67, 0.92);
    static Fb 布阵按钮 = new Fb("布阵按钮", 0x61ad19, "-21|-17|0xf6ffec,28|-13|0xf6ffec,11|20|0xf6ffec,172|6|0x59a715,324|-6|0xebc137", 90, 0.32, 0.47, 0.54, 0.71);
    static Fb 关闭按钮X = new Fb("关闭按钮X", 0xfaead1, "-13|-5|0xfae9cf,15|-11|0xfcf1d5,-6|-30|0xe57c3d,-6|31|0xd8602d", 90, 0.81, 0.13, 0.98, 0.52);
    //将 特征
    static Fb 司马懿 = new Fb("司马懿",0x3f5ea1, "-29|-49|0xf66246,-55|31|0x795287,36|30|0x700201,-91|29|0x720201,-64|-30|0x3f5d9d,28|41|0x8d5f50", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 贾诩 = new Fb("贾诩",0x583c6c, "89|-11|0xc36501,-7|-48|0x9c918f,66|-49|0x978d8b,49|-29|0x8b7e78,-16|11|0x706796,82|-90|0xbf660a,-10|-76|0xd37e2b", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 狗子 = new Fb("狗子",0x314381, "-49|30|0xc36501,-22|-13|0x405e9e,19|48|0xb43b33,56|49|0x8f2e25,73|-4|0x354880,-22|80|0x83716d,-14|11|0xebc860,-13|25|0xfddf71", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 华佗 = new Fb("华佗",0xe89c7a, "22|-63|0xc36501,-66|-53|0xcf7e2c,-20|31|0xfdf6e4,-42|-4|0xd5ccbb,12|-26|0xded0c3,20|20|0xe3dac9,-98|4|0x174423", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 郭嘉 = new Fb("郭嘉",0xfdd2af, "31|27|0x700201,-60|-62|0x3f64ab,-10|-21|0x653e37,18|-22|0x57372c,-73|1|0xcfa187,-82|-2|0x2a1a1d,-32|-61|0x361e1c", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 貂蝉 = new Fb("貂蝉",0xf4e0d9, "-20|3|0xca82ce,18|2|0xca82ce,33|11|0x6b0503,-63|-55|0xce802d,-80|12|0x700201,-38|-62|0xf0eef1,-92|-23|0xc89099", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 魏延 = new Fb("魏延",0xf5c5a1, "33|12|0xc36501,-27|-17|0x422829,-65|-51|0x1f5b37,-69|-5|0xffee91,-85|-8|0xcaa561,-47|-46|0xe7ba9b,-50|10|0xf4cf81,-66|-21|0xe6b192", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 蔡文姬 = new Fb("蔡文姬",0xe3d0c2, "-23|-15|0x150909,25|13|0xc36501,48|-4|0xf04430,-61|-59|0x3e64ab,7|-40|0xedb47d,-5|-38|0xfef0c3,-36|-17|0xd09d9c,16|25|0x281312", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 吕布 = new Fb("吕布",0xf6c8a4, "6|-17|0x983223,36|-17|0x6b0503,44|-17|0xd82d19,-67|-66|0xc47725,-50|-77|0xd79535,-45|-63|0xffed5f,-7|-32|0xeeae57,-86|3|0xf8e388", 90, 0.06, 0.56, 0.95, 0.92);
    static Fb 陪练 = new Fb("陪练",0xdfa57f, "-12|-36|0x908282,-19|-26|0xd1c7bd,-72|-11|0x5a3421,-80|-2|0x663d27,36|-13|0xdad4c6,23|5|0xdddac9,37|22|0xdddac9,-73|-21|0xe0d9c9", 90, 0.06, 0.56, 0.95, 0.92);

    private boolean 司马懿_大;
    private boolean 魏延_大;
    private boolean 魏延2_大;
    private boolean 魏延3_大;
    private boolean 陪练_大;


    private boolean 贾诩_中;
    private boolean 蔡文姬_中;
    private boolean 华佗_中;
    private boolean 华佗2_中;
    private boolean 陪练_中;


    private boolean 狗子_小;
    private boolean 郭嘉_小;
    private boolean 貂蝉_小;
    private boolean 吕布_小;
    private boolean 陪练_小;


//    static Fb 获嘉 = new Fb("",, 90, 0.06, 0.56, 0.95, 0.92);



    class 好友主城界面_回调 implements Fcallback {
        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            //点一次 可占领 就不点了
            已清空队伍=false;
            slideCunt = 0;
            当前队伍 = null;
            重置将领();
            if (可占领被点击 == false) {
                if (可占领.click() != null) {
                    可占领被点击 = true;
                }
            }

            if (找到大矿 && 找到中矿 && 找到小矿){
                ScreenLib.click(x,y,500f);//三矿齐全 回城
            }


            if (左滑翻页.click() != null) {//翻页
                可占领被点击 = false;
            }else{
                ScreenLib.click(x,y,500f);//到最后一页 回城
            }
        }
    }


    class 主城界面内_回调 implements Fcallback {
        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            //领取矿
            while (可领取_黄色.click() != null) {
                if (可领取_黄色.click() == null) {
                    break;
                }
            }

            if (大矿.findColor() != null) {
                找到大矿 = true;
            }else{
                找到大矿 = false;
            }

            if (中矿.findColor() != null) {
                找到中矿 = true;
            }else{
                找到中矿 = false;
            }

            if (小矿.findColor() != null) {
                找到小矿 = true;
            }else{
                找到小矿 = false;
            }

            if (找到大矿 && 找到中矿 && 找到小矿) {
                //三矿齐全
            } else {
                //点击进入好友列表
                进入好友列表图标.click();
            }

        }
    }

    class 小矿界面_回调 implements Fcallback {
        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            if (找到小矿 == false) {
                占矿布阵防守按钮.click();
                找到小矿 = true;
                当前队伍 = "小";
            } else {
                关闭按钮X.click();
            }
        }
    }

    class 中矿界面_回调 implements Fcallback {
        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            if (找到中矿 == false) {
                占矿布阵防守按钮.click();
                找到中矿 = true;
                当前队伍 = "中";
            } else {
                关闭按钮X.click();
            }
        }
    }

    class 大矿界面_回调 implements Fcallback {
        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            if (找到大矿 == false) {
                占矿布阵防守按钮.click();
                找到大矿 = true;
                当前队伍 = "大";
            } else {
                关闭按钮X.click();
            }
        }
    }

    class 防守布阵界面_回调 implements Fcallback{
        @SuppressLint("ShowToast")
        @Override
        public void fCallback(int x, int y, int t, int r) throws InterruptedException {
            下将();

            if (当前队伍=="大" ) {
                if (大矿队伍()) {
                    ScreenLib.click(x, y);//点击布阵防守按钮
                } else {
                    ScreenLib.screenSlide(444, 1712, 445, 1517);//滑动 选将
                    slideCunt+=1;
                    if (slideCunt >20){
                       关闭按钮X.click();//退出 不占领
                    }
                }
            }
            if (当前队伍=="中" ) {
                if (中矿队伍()) {
                    ScreenLib.click(x, y);
                } else {
                    ScreenLib.screenSlide(444, 1712, 445, 1517);//滑动 选将
                    slideCunt+=1;
                    if (slideCunt >20){
                        关闭按钮X.click();//退出 不占领
                    }
                }
            }
            if (当前队伍=="小" ) {
                if (小矿队伍()) {
                    ScreenLib.click(x, y);
                } else {
                    ScreenLib.screenSlide(444, 1712, 445, 1517);//滑动 选将
                    slideCunt+=1;
                    if (slideCunt >20){
                        关闭按钮X.click();//退出 不占领
                    }
                }
            }



        }
    }
    @Override
    protected List<Fa> getFa() {
        List<Fa> pageList = new ArrayList<Fa>();//页面特征
        pageList.add(new Fa("主城界面内", new 主城界面内_回调(), 0xfddc39, "1|23|0xffe038,254|10|0xfee239,-18|-31|0xfbf0d2", 70, 0.00, 0.85, 0.08, 0.99));
        pageList.add(NPC胡来来);
        pageList.add(恭喜获得);
        pageList.add(new Fa("好友主城界面", new 好友主城界面_回调(), 0xfae536, "-49|26|0xb02222,-87|19|0xc29542,34|35|0xbc8d3d", 70, 0.01, 0.80, 0.18, 0.98));
        pageList.add(new Fa("小矿界面", new 小矿界面_回调(), 0xc99e42, "45|-1|0x947210,15|-61|0xf6ca71,87|-104|0xf6d258,-15|-86|0xf7d05b", 60, 0.05, 0.21, 0.32, 0.40));
        pageList.add(new Fa("中矿界面", new 中矿界面_回调(), 0xe377e6, "44|3|0x261565,84|-79|0x9a11f7,-2|-43|0x9811f4,-58|-68|0xd391fd", 90, 0.04, 0.20, 0.32, 0.45));
        pageList.add(new Fa("大矿界面", new 大矿界面_回调(), 0x3c9bc9, "29|-4|0x227cb1,103|-38|0x5ce5f7,0|-58|0x39dff7,-49|-101|0x65e7f7,87|-112|0x4be2f7", 90, 0.04, 0.18, 0.34, 0.47));
        pageList.add(new Fa("防守布阵界面", new 防守布阵界面_回调(), 0x61ad19, "-21|-17|0xf6ffec,28|-13|0xf6ffec,11|20|0xf6ffec,172|6|0x59a715,324|-6|0xebc137", 90, 0.32, 0.47, 0.54, 0.71));

        return pageList;
    }

    @Override
    public Map<String, List<Fb>> getFb() {
        Map<String, List<Fb>> map = new HashMap<String, List<Fb>>();
        List<Fb> 主城界面内 = new ArrayList<Fb>();
        //主城界面内.add(可领取_黄色b);


        map.put("主城界面内", 主城界面内);
        return map;
    }

    private void 重置将领(){
        司马懿_大 = false;
        魏延_大 = false;
        魏延2_大 = false;
        魏延3_大 = false;
        陪练_大 = false;

        贾诩_中 = false;
        蔡文姬_中 = false;
        华佗_中 = false;
        华佗2_中 = false;
        陪练_中 = false;

        狗子_小 = false;
        郭嘉_小 = false;
        貂蝉_小 = false;
        吕布_小 = false;
        陪练_小 = false;

    }

    private void 下将() throws InterruptedException {
        if (已清空队伍 ==false){
            ScreenLib.click(908,814,400f,10);
            ScreenLib.click(755,814,400f,10);
            ScreenLib.click(566,814,400f,10);
            ScreenLib.click(361,814,400f,10);
            ScreenLib.click(165,814,400f ,10);
            已清空队伍 = true;
        }
    }
    private boolean 大矿队伍() throws InterruptedException {
        if (司马懿_大==false){
            if (司马懿.click()!=null){
                司马懿_大=true;
            }
        }
        if (魏延_大==false){
            if (魏延.click()!=null){
                魏延_大=true;
            }
        }
        if (魏延2_大==false){
            if (魏延.click()!=null){
                魏延2_大=true;
            }
        }
        if (魏延3_大==false){
            if (魏延.click()!=null){
                魏延3_大=true;
            }
        }
        if (陪练_大==false){
            if (陪练.click()!=null){
                陪练_大=true;
            }
        }

        if (司马懿_大 && 魏延_大 && 魏延2_大 && 魏延3_大 && 陪练_大){
            重置将领();
            return true;
        }else{
            return false;
        }

    }
    private boolean 中矿队伍() throws InterruptedException {
        if (贾诩_中==false){
            if (贾诩.click()!=null){
                贾诩_中=true;
            }
        }
        if (蔡文姬_中==false){
            if (蔡文姬.click()!=null){
                蔡文姬_中=true;
            }
        }
        if (华佗_中==false){
            if (华佗.click()!=null){
                华佗_中=true;
            }
        }
        if (华佗2_中==false){
            if (华佗.click()!=null){
                华佗2_中=true;
            }
        }
        if (陪练_中==false){
            if (陪练.click()!=null){
                陪练_中=true;
            }
        }

        if (贾诩_中 && 蔡文姬_中 && 华佗_中 && 华佗2_中 && 陪练_中){
            重置将领();
            return true;
        }else{
            return false;
        }
    }
    private boolean 小矿队伍() throws InterruptedException {
        if (狗子_小==false){
            if (狗子.click()!=null){
                狗子_小=true;
            }
        }
        if (郭嘉_小==false){
            if (郭嘉.click()!=null){
                郭嘉_小=true;
            }
        }
        if (貂蝉_小==false){
            if (貂蝉.click()!=null){
                貂蝉_小=true;
            }
        }
        if (吕布_小==false){
            if (吕布.click()!=null){
                吕布_小=true;
            }
        }
        if (陪练_小==false){
            if (陪练.click()!=null){
                陪练_小=true;
            }
        }

        if (狗子_小 && 郭嘉_小 && 貂蝉_小 && 吕布_小 && 陪练_小){
           重置将领();
            return true;
        }else{
            return false;
        }
    }
}
