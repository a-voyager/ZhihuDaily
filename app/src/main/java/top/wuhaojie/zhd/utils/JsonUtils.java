package top.wuhaojie.zhd.utils;

import com.google.gson.Gson;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/11 16:37
 * Version: 1.0
 */

public class JsonUtils {

    private static Gson mGson = new Gson();

    private JsonUtils() {
    }


    public static String toJson(Object src) {
        return mGson.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return mGson.fromJson(json, classOfT);
    }

}
