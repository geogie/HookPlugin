package com.george.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.george.test.framework.Constants;

/**
 * Created By George
 * Description:
 */
public class StubActivity extends Activity {
    public static final String TAG = "StubActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.tv_launch)).setText("StubActivity");
        if (Constants.DEBUG) Log.e(TAG, "onCreate");
    }
}