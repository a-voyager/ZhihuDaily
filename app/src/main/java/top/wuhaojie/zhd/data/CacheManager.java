package top.wuhaojie.zhd.data;

import android.content.Context;
import android.support.annotation.Nullable;

import top.wuhaojie.zhd.constant.Constants;
import top.wuhaojie.zhd.data.dto.LocalDBManager;
import top.wuhaojie.zhd.data.dto.WebCache;
import top.wuhaojie.zhd.entities.BeforeMessageResponse;
import top.wuhaojie.zhd.entities.DetailMessageResponse;
import top.wuhaojie.zhd.entities.LatestMessageResponse;
import top.wuhaojie.zhd.utils.JsonUtils;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/10 22:19
 * Version: 1.0
 */

public class CacheManager {

    private CacheManager() {
    }


    public static void saveLatestMessages(Context context, LatestMessageResponse latestMessageResponse) {
        LocalDBManager manager = LocalDBManager.getInstance(context);
        WebCache cache = new WebCache(null, Constants.CACHE_TYPE_LATEST_MESSAGES, null, JsonUtils.toJson(latestMessageResponse), System.currentTimeMillis());
        manager.insert(cache);
    }

    public static boolean hasLatestMessages(Context context) {
        LocalDBManager manager = LocalDBManager.getInstance(context);
        WebCache cache = manager.queryLastOne(Constants.CACHE_TYPE_LATEST_MESSAGES);
        return cache != null;
    }

    @Nullable
    public static LatestMessageResponse getLatestMessages(Context context) {
        LocalDBManager manager = LocalDBManager.getInstance(context);
        WebCache cache = manager.queryLastOne(Constants.CACHE_TYPE_LATEST_MESSAGES);
        if (cache == null) return null;
        String content = cache.getContent();
        return JsonUtils.fromJson(content, LatestMessageResponse.class);
    }


    public static void saveDetailMessage(Context context, DetailMessageResponse response) {
        String extra = String.valueOf(response.getId());
        WebCache cache = new WebCache(null, Constants.CACHE_TYPE_DETAIL_MESSAGE, extra, JsonUtils.toJson(response), System.currentTimeMillis());
        LocalDBManager.getInstance(context).insert(cache);
    }

    public static boolean hasDetailMessage(Context context, String id) {
        LocalDBManager manager = LocalDBManager.getInstance(context);
        WebCache cache = manager.queryLastOne(Constants.CACHE_TYPE_DETAIL_MESSAGE, id);
        return cache != null;
    }

    @Nullable
    public static DetailMessageResponse getDetailMessage(Context context, String id) {
        LocalDBManager manager = LocalDBManager.getInstance(context);
        WebCache cache = manager.queryLastOne(Constants.CACHE_TYPE_DETAIL_MESSAGE, id);
        if (cache == null) return null;
        String content = cache.getContent();
        return JsonUtils.fromJson(content, DetailMessageResponse.class);

    }

    public static void saveBeforeMessage(Context context, BeforeMessageResponse response, String extra) {
        WebCache cache = new WebCache(null, Constants.CACHE_TYPE_BEFORE_MESSAGE, extra, JsonUtils.toJson(response), System.currentTimeMillis());
        LocalDBManager.getInstance(context).insert(cache);
    }

    public static boolean hasBeforeMessage(Context context, String date) {
        LocalDBManager manager = LocalDBManager.getInstance(context);
        WebCache cache = manager.queryLastOne(Constants.CACHE_TYPE_BEFORE_MESSAGE, date);
        return cache != null;
    }

    @Nullable
    public static BeforeMessageResponse getBeforeMessage(Context context, String date) {
        LocalDBManager manager = LocalDBManager.getInstance(context);
        WebCache cache = manager.queryLastOne(Constants.CACHE_TYPE_BEFORE_MESSAGE, date);
        if (cache == null) return null;
        String content = cache.getContent();
        return JsonUtils.fromJson(content, BeforeMessageResponse.class);
    }

    public static void saveSplashTag(Context context, String tag) {
        WebCache cache = new WebCache(null, Constants.CACHE_TYPE_SPLASH_TAG, tag, null, System.currentTimeMillis());
        LocalDBManager.getInstance(context).insert(cache);
    }

    public static boolean hasSplashTag(Context context, String tag) {
        WebCache cache = LocalDBManager.getInstance(context).queryLastOne(Constants.CACHE_TYPE_SPLASH_TAG, tag);
        return cache != null;
    }

    @Nullable
    public static String getSplashTag(Context context) {
        WebCache cache = LocalDBManager.getInstance(context).queryLastOne(Constants.CACHE_TYPE_SPLASH_TAG);
        if (cache == null) return null;
        return cache.getExtra();
    }


}
