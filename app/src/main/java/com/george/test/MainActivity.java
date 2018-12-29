package com.george.test;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

import com.george.test.framework.Constants;
import com.george.test.framework.PluginManager;
import com.george.test.framework.ReflectUtil;

public class MainActivity extends Activity implements View.OnClickListener {
    // https://zhuanlan.zhihu.com/p/33017826
    public static final String TAG = "MainActivity";
    private String mPluginPackageName = "com.george.plugin";
    private String mPluginClassName = "com.george.plugin.MainActivity";
    //读写权限
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;
    private PluginManager mPluginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initPlugin();
    }

    private void initPlugin() {
        // !! must first
        ReflectUtil.init();
        mPluginManager = PluginManager.getInstance(getApplicationContext());
        mPluginManager.hookInstrumentation();
        mPluginManager.hookCurrentActivityInstrumentation(this);
    }

    private void initData() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }
    }

    private void initView() {
        (findViewById(R.id.tv_launch)).setOnClickListener(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        // !!! 不要在此Hook,看源码发现mInstrumentaion会在此方法后初始化
    }

    @Override
    public void onClick(View view) {
        if (Constants.DEBUG) Log.e(TAG, "click view id: " + view.getId());
        if (view.getId() == R.id.tv_launch) {
            // TODO launch plugin app
            if (mPluginManager.loadPlugin(Constants.PLUGIN_PATH)) {
                Intent intent = new Intent();
                intent.setClassName(mPluginPackageName, mPluginClassName);
                startActivity(intent);
            }
        }
    }
}
