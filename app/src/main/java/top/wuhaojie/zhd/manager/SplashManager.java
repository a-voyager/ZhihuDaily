package top.wuhaojie.zhd.manager;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.io.File;

import okhttp3.ResponseBody;
import rx.Subscriber;
import top.wuhaojie.zhd.App;
import top.wuhaojie.zhd.data.CacheManager;
import top.wuhaojie.zhd.data.HttpUtils;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/23 21:07
 * Version: 1.0
 */

public class SplashManager {

    private SplashManager() {
    }

    /**
     * store image if not exists
     *
     * @param tag the new id
     * @param url the url for the id
     */
    public static void save(String tag, String url) {
        if (CacheManager.hasSplashTag(App.getContext(), tag)) return;
        // load url & save with tag as fileName
        File des = getFile(tag);
        if (des == null) return;
        HttpUtils.downloadFile(url, des, new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                CacheManager.saveSplashTag(App.getContext(), tag);
            }
        });

    }


    /**
     * load the last file
     *
     * @return the image file uri
     */
    @Nullable
    public static String load() {
        String tag = CacheManager.getSplashTag(App.getContext());
        if (TextUtils.isEmpty(tag)) {
            return null;
        }
        // the tag is file name
        File file = getFile(tag);
        if (file != null && file.exists()) {
            return file.toURI().toString();
        }
        return null;
    }


    @Nullable
    private static File getFile(String tag) {
        if (TextUtils.isEmpty(tag)) return null;
        File parent = App.getContext().getCacheDir();
        return new File(parent, tag);
    }

}
