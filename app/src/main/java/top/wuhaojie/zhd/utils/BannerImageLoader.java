package top.wuhaojie.zhd.utils;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        top.wuhaojie.lib.image.ImageLoader.get().load((String) path, imageView);
    }
}
