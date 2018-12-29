package com.george.test.framework;

import android.content.res.Resources;

/**
 * Created By George
 * Description:
 */
public class PluginApp {
    public Resources mResources;
    public ClassLoader mClassLoader;


    public PluginApp(Resources mResources) {
        this.mResources = mResources;
    }
}
