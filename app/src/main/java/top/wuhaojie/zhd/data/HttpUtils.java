package top.wuhaojie.zhd.data;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import top.wuhaojie.lib.http.RetrofitHttpHelper;
import top.wuhaojie.zhd.data.api.APIService;
import top.wuhaojie.zhd.entities.DetailMessageResponse;
import top.wuhaojie.zhd.entities.LatestMessageResponse;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class HttpUtils {

    // 坑: 导包
    // 依赖是 'io.reactivex:rxandroid:1.2.1'
    // 不是基于 rxjava2 的版本

    // rx 包下是1.xx版本
    // io.reactive 包下是2.xx版本


    private static RetrofitHttpHelper<APIService> mRetrofitHttpHelper = new RetrofitHttpHelper<>(APIService.BASE_URL, APIService.class);

    private HttpUtils() {
    }

    public static void getStartImage() {
        mRetrofitHttpHelper.getService().getStartImage();
    }


    public static void getLatestMessages(Subscriber<LatestMessageResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getLatestMessages()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public static void getDetailMessage(String id, Subscriber<DetailMessageResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getDetailMessage(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
