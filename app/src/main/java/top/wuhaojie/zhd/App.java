package top.wuhaojie.zhd;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import top.wuhaojie.lib.image.ImageLoader;
import top.wuhaojie.lib.image.impl.GlideImageLoader;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(GlideImageLoader.create(this));
        sContext = this.getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }

}
