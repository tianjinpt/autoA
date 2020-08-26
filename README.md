
### 类
1. ScreenLib类 封装了模糊找色，屏幕点击，屏幕滑动等方法。
1. TsFrame抽象类 封装了脚本的逻辑流程（帮助你快速开发脚本）
1. Fa和Fb 都是继承自F，他们大部分方法都是一样的。重新封装了屏幕点击和模糊找色的方法给TsFrame.
1. 继承关系：ScreenLib → F → Fa（Fb同此）

### 怎么创建一个游戏脚本？
1. 创建一个class继承TsFrame重写getFa和getFb方法即可。

### 示例代码:
```java
public class ScriptTest extends TsFrame {
   
    //Fa和Fb 的fcallback参数 传递一个实现Fcallback接口的内部类 作为回调。（复杂逻辑的脚本应该使用它）
    
    @Override
    protected List<Fa> getFa() {
        List<Fa> fa= new ArrayList<Fa>();
        //界面特征 
        fa.add(new Fa("主界面",0xf4c51f, "1|-17|0x000000,-25|-41|0xf4c51f,28|-45|0xf4c51f,21|12|0xf4c51f,18|-8|0x000000,-1|-24|0x000000", 90, 40, 97, 691, 487));
      
        return fa;
    }

    @Override
    public Map<String, List<Fb>> getFb() {
        Map<String, List<Fb>> map = new HashMap<String, List<Fb>>();//类似于lua中的字典类型
        List<Fb> 主界面 = new ArrayList<Fb>();//list存放Fb对象
        主界面.add(new Fb("点击主线任务",0xf4c51f, "1|-17|0x000000,-25|-41|0xf4c51f,28|-45|0xf4c51f,21|12|0xf4c51f,18|-8|0x000000,-1|-24|0x000000", 90, 40, 97, 691, 487))
        主界面.add(new Fb("点击背包按钮",0xf4c512, "4|-17|0x000000,-25|-41|0xf4c51f,28|-45|0xf4c51f,21|12|0xf4c51f,18|-8|0x000000,-1|-24|0x000000", 90, 40, 97, 691, 487))
        主界面.add(new Fb("点击返回按钮",0xf4c512, "4|-17|0x000000,-25|-41|0xf4c51f,28|-45|0xf4c51f,21|12|0xf4c51f,18|-8|0x000000,-1|-24|0x000000", 90, 40, 97, 691, 487))
        
        map.push(主界面)
        return map;
    }
}
```

### 触动精灵用户快速上手
1. 取色工具可以用触动精灵的取色工具`TSColorPick`触动精灵官网下载（手机取色工具代码好像被我误删了）
1. ScreenLib.findColor()方法参数同触动精灵的findMultiColorInRegionFuzzy()函数（细微区别下面解说），所以`TSColorPick`自动生成的代码可以直接把参数给ScreenLib.findColor()
   
## ScreenLib.findColor()与触动精灵findMultiColorInRegionFuzzy()参数的差别
1. ScreenLib.findColor() x,y,x2,y2找色范围，可以是整数，也可以是小数（即百分比）
1. ScreenLib.findColor() 相似度参数 值越小相似度越高（0为一模一样）


