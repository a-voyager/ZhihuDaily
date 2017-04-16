package top.wuhaojie.zhd.data;

import android.content.Context;
import android.support.annotation.Nullable;

import top.wuhaojie.zhd.constant.Constants;
import top.wuhaojie.zhd.data.dto.LocalDBManager;
import top.wuhaojie.zhd.data.dto.WebCache;
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
        WebCache cache = new WebCache(null, Constants.CACHE_TYPE_LATEST_MESSAGES, JsonUtils.toJson(latestMessageResponse), System.currentTimeMillis());
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


}
