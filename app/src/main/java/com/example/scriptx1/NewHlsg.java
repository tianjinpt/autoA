package com.example.scriptx1;


import com.example.scriptx1.scriptframe.Fa;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewHlsg extends TsFrame {
    private static NewHlsg instance=null;
    private NewHlsg(){}
    public static NewHlsg  getInstance(){
        if (instance==null){
            instance= new NewHlsg();
        }
        return instance;

    }




    @Override
    protected List<Fa> getFa() {
        List<Fa> fa= new ArrayList<Fa>();
        fa.add(new Fa("主城界面",0xee863d, "-1|-26|0x72f0ff,-1|27|0xeee83a,42|-27|0x74efff,41|0|0xe98841,44|28|0xede842", 90, 66, 1012, 156, 1150));
        //fa.add(new Fa("试炼界面1",0xb4adab, "-85|32|0xfedc37,83|32|0xfedc37,-36|-16|0x901010,30|-13|0x900e10,-36|28|0xdc371f,32|32|0xc52815", 90, 307, 1176, 404, 1233));
        fa.add(new Fa("试炼界面", 0xb4afad, "-63|-32|0x8b0714,48|37|0xc12816,-57|41|0xdd381d,50|-21|0x7a0810,-95|0|0xfbf0d2", 90, 0.24, 0.84, 0.73, 0.95));


        return fa;
    }

    @Override
    public Map<String, List<Fb>> getFb() {
        Map<String, List<Fb>> map = new HashMap<String, List<Fb>>();
        List<Fb> 主城界面 = new ArrayList<Fb>();
        主城界面.add(new Fb("点击试炼",0x98908d, "-56|-13|0xc3a780,-43|0|0x900a11,22|2|0x8d0712,-40|38|0xdf3b22,27|40|0xc52815,-12|22|0xb5adab", 90, 361, 1152, 452, 1266));
        map.put("主城界面",主城界面);

        List<Fb> 试炼界面 = new ArrayList<Fb>();
//        试炼界面.add(new Fb(0x61b01a, "-51|20|0x41900e,-51|-18|0x79c625,-113|0|0x60af1a", 90, 591, 339, 662, 704));
//        map.put("试炼界面1",试炼界面);
        试炼界面.add(new Fb("开战1", 0xf4ffe8,
                "0|5|0x6cb22b,-1|14|0xf4ffea,-7|8|0xf4ffe8,8|8|0xcee4be,19|8|0x68b31b,-23|6|0x6ab51c,-4|34|0x499a0f,-3|-16|0x7bc822",
                90, 0.81, 0.22, 0.84, 0.58, 300, 11));
        map.put("试炼界面",试炼界面);
        return map;
    }
}
