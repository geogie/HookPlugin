package com.george.test.framework;

import android.os.Environment;

/**
 * Created By George
 * Description:
 */
public class Constants {
    public final static String KEY_IS_PLUGIN = "key_is_plugin";
    public final static String KEY_PACKAGE =  "key_package";
    public final static String KEY_ACTIVITY = "key_activity";

    public final static String FIELD_RESOURCES = "mResources";

    public static final String STUB_ACTIVITY = "com.george.test.StubActivity";
    public static final String STUB_PACKAGE = "com.george.test";

    public static final String PLUGIN_PATH = Environment.getExternalStorageDirectory() + "/plugins/plugin.apk";
    public final static boolean DEBUG = true;
}
