package top.wuhaojie.zhd;

import android.app.Application;

import top.wuhaojie.lib.image.ImageLoader;
import top.wuhaojie.lib.image.impl.GlideImageLoader;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.init(GlideImageLoader.create(this));
    }
}
