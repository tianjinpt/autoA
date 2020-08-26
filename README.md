### 怎么创建一个脚本？
1. 创建一个class继承TsFrame重写getFa和getFb方法即可。

### 示例代码:
```java
public class ScriptTest extends TsFrame {
    
    //Fa和Fb都是继承自F，他们大部分方法都是一样的。
    //Fa和Fb封装了屏幕点击的方法给TsFrame
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
