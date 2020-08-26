package com.example.scriptx1;

import com.example.scriptx1.scriptframe.Fa;
import com.example.scriptx1.scriptframe.Fb;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScriptTest extends TsFrame {
    private static ScriptTest instance = null;
    private ScriptTest(){}

    public static ScriptTest getInstance() {
        if (instance == null){
            instance = new ScriptTest();
        }
        return instance;
    }

    @Override
    protected List<Fa> getFa() {
        List<Fa> fa= new ArrayList<Fa>();

        fa.add(new Fa(0xf4c51f, "1|-17|0x000000,-25|-41|0xf4c51f,28|-45|0xf4c51f,21|12|0xf4c51f,18|-8|0x000000,-1|-24|0x000000", 90, 40, 97, 691, 487));

        return fa;
    }

    @Override
    public Map<String, List<Fb>> getFb() {
        return null;
    }
}
