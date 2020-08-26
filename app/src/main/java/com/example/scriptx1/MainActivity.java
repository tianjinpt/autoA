package com.example.scriptx1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.graphics.PixelFormat;
import android.hardware.display.DisplayManager;

import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.scriptx1.screendo.GBData;
import com.example.scriptx1.scriptframe.TsFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_MEDIA_PROJECTION = 1;
    private MediaProjectionManager mMediaProjectionManager;
    private static MediaProjection mMediaProjection;
    public static ImageReader MimageReader;



    public static Context CONTEXT;

    public static int ScreenOrientation=-1 ;//屏幕方向

    public static WindowManager windowManager;
    public static ColorSelectedFloatWindowBig f;
    public static int w, h;
    public static AlertDialog.Builder bu;
    public ListView listView;
    List listData;
    Menu MyMenu;
    public static TsFrame script = null;



    @SuppressLint("HandlerLeak")
    public static Handler MainHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x00001:
                    Bundle bundle = msg.getData();
                    Toast.makeText(MainActivity.CONTEXT, bundle.getString("key"), Toast.LENGTH_SHORT).show();
                    break;
                case 0x00002:
                    break;

            }
        }
    };


    @Override //创建菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menui, menu);
        MyMenu=menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override //菜单按钮点击事件
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuF://悬浮窗按钮
                initFloatWindow();
                break;
            case R.id.menuA://无障碍服务按钮
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.menuy://竖屏
                item.setEnabled(false);

                MyMenu.findItem(R.id.menux).setEnabled(false);
                ScreenOrientation=0;
                setUpVirtualDisplay();
                break;
            case R.id.menux://横屏
                item.setEnabled(false);

                MyMenu.findItem(R.id.menuy).setEnabled(false);
                ScreenOrientation=1;
                setUpVirtualDisplay();
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    private void init() {
        initDialog();
        initFloatWindow();
        initAdapter();
    }

    private void initDialog() {
        if (bu == null) {
            bu = new AlertDialog.Builder(this);
            bu.setTitle("悬浮窗权限申请");
            bu.setMessage("是否开启悬浮窗权限？");

            bu.setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent1 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    CONTEXT.startActivity(intent1);
                }
            });
            bu.setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });

            bu.create();
        }
    }

    //初始化悬浮窗
    private void initFloatWindow() {
        if (f == null) {
            f = new ColorSelectedFloatWindowBig(this, R.layout.f_layout);
            f.floatWindowShow();
        } else {
            f.floatWindowShow();
        }
    }

    //初始化listView的数据
    private void initAdapter() {
        if (listData == null) {
            listData = new ArrayList<Map<String, Object>>();
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("title", "王者荣耀自动刷金币");
            map1.put("describe", "作者：黑猫\nQQ：2920007919/3139302743\n简介：适配多分辨率。使用前请开启无障碍服务。");

            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("title", "胡莱三国自动爬塔");
            map2.put("describe", "作者：黑猫\nQQ：2920007919/3139302743\n简介：适配多分辨率。使用前请开启无障碍服务。");

            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("title", "胡莱三国自动找矿");
            map3.put("describe", "作者：黑猫\nQQ：2920007919/3139302743\n简介：适配多分辨率。使用前请开启无障碍服务。");

            Map<String, Object> map4 = new HashMap<String, Object>();
            map4.put("title", "胡莱自动爬塔");
            map4.put("describe", "作者：黑猫\nQQ：2920007919/3139302743\n简介：适配多分辨率。使用前请开启无障碍服务。");

            Map<String, Object> map5 = new HashMap<String, Object>();
            map5.put("title", "脚本测试");
            map5.put("describe", "作者：黑猫\nQQ：2920007919/3139302743\n简介：适配多分辨率。使用前请开启无障碍服务。");

            listData.add(map5);
            listData.add(map1);
            listData.add(map2);
            listData.add(map3);
            listData.add(map4);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        windowManager = getWindowManager();
        CONTEXT = getApplicationContext();
        //初始化操作
        init();
        listView = findViewById(R.id.listView);
        //listView的适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listData, R.layout.list_item, new String[]{"title", "describe"}, new int[]{R.id.textView2, R.id.textView3});
        listView.setAdapter(simpleAdapter);
        //list的Item点击事件监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TextView textView = view.findViewById(R.id.textView2);

                //关闭正在运行的脚本 并且 选择新的脚本
                if (MainActivity.script!=null && MainActivity.script.getFlag()==1){
                    ColorSelectedFloatWindowBig.setButtonStatus();
                }

                switch(((Map<String, Object>)listData.get(position)).get("title").toString()){
                    case "王者荣耀自动刷金币":
                        MainActivity.script = ScriptWzRy.getInstance();
                        break;
                    case "胡莱三国自动爬塔":
                        MainActivity.script = MyScript.getInstance();
                        break;
                    case "胡莱三国自动找矿":
                        MainActivity.script = ScriptZdZk.getInstance();
                        break;
                    case "胡莱自动爬塔":
                        MainActivity.script = NewHlsg.getInstance();
                        break;
                    case "脚本测试":
                        MainActivity.script = ScriptTest.getInstance();
                        break;

                }
            }
        });





        //以下不要更改

        mMediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        assert mMediaProjectionManager != null;
        startActivityForResult(
                mMediaProjectionManager.createScreenCaptureIntent(),
                REQUEST_MEDIA_PROJECTION);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_MEDIA_PROJECTION) {
            if (resultCode != Activity.RESULT_OK) {
                Log.i("z", "User cancelled");
                Toast.makeText(this, "User cancelled!", Toast.LENGTH_SHORT).show();
                return;
            }
            Log.i("x", "Starting screen capture1");
            mMediaProjection = mMediaProjectionManager.getMediaProjection(resultCode, data);

            //setUpVirtualDisplay();
        }
    }

    public static void setUpVirtualDisplay() {
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(dm);
        if (ScreenOrientation==1) {//横屏
            w = dm.heightPixels;
            h = dm.widthPixels;
        }else {
            h=dm.heightPixels;
            w=dm.widthPixels;
        }

        MimageReader = ImageReader.newInstance(w, h, PixelFormat.RGBA_8888, 1);
        mMediaProjection.createVirtualDisplay("ScreenCapture",
                w, h,  dm.densityDpi,
                DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                MimageReader.getSurface(), null, null);

        GBData.reader = MimageReader;
    }

    @Override
    public void onBackPressed() {//重写的Activity返回
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);

    }


}
