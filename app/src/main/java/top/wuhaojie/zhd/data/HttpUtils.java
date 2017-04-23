package top.wuhaojie.zhd.data;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.File;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import top.wuhaojie.lib.http.RetrofitHttpHelper;
import top.wuhaojie.zhd.App;
import top.wuhaojie.zhd.data.api.APIService;
import top.wuhaojie.zhd.data.api.ExtraService;
import top.wuhaojie.zhd.entities.BeforeMessageResponse;
import top.wuhaojie.zhd.entities.DetailMessageResponse;
import top.wuhaojie.zhd.entities.LatestMessageResponse;
import top.wuhaojie.zhd.entities.LongCommentResponse;
import top.wuhaojie.zhd.entities.ShortCommentResponse;
import top.wuhaojie.zhd.entities.StartImageResponse;
import top.wuhaojie.zhd.entities.StoryExtraResponse;
import top.wuhaojie.zhd.utils.StringUtils;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class HttpUtils {
    private static final String TAG = "HttpUtils";

    // 坑: 导包
    // 依赖是 'io.reactivex:rxandroid:1.2.1'
    // 不是基于 rxjava2 的版本

    // rx 包下是1.xx版本
    // io.reactive 包下是2.xx版本


    private static RetrofitHttpHelper<APIService> mRetrofitHttpHelper = new RetrofitHttpHelper<>(APIService.BASE_URL, APIService.class);
    private static RetrofitHttpHelper<ExtraService> mExtraHttpHelper = new RetrofitHttpHelper<>(APIService.BASE_URL, ExtraService.class, false);

    private HttpUtils() {
    }

    public static void getStartImage(int width, int height, Subscriber<StartImageResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getStartImage(width, height)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public static void getLatestMessages(Subscriber<LatestMessageResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getLatestMessages()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(latestMessageResponse -> CacheManager.saveLatestMessages(App.getContext(), latestMessageResponse))
                .doOnError(throwable -> {
                    if (CacheManager.hasLatestMessages(App.getContext())) {
                        LatestMessageResponse response = CacheManager.getLatestMessages(App.getContext());
                        subscriber.onNext(response);
                    }
                })
                .subscribe(subscriber);
    }


    public static void getDetailMessage(String id, Subscriber<DetailMessageResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getDetailMessage(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(response -> CacheManager.saveDetailMessage(App.getContext(), response))
                .doOnError(throwable -> {
                    if (CacheManager.hasDetailMessage(App.getContext(), id)) {
                        DetailMessageResponse response = CacheManager.getDetailMessage(App.getContext(), id);
                        subscriber.onNext(response);
                    }
                })
                .subscribe(subscriber);
    }

    public static void getStoryExtra(String id, Subscriber<StoryExtraResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getStoryExtra(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public static void getBeforeMessage(int page, Subscriber<BeforeMessageResponse> subscriber) {
        // ZhiHu API 为获取参数前一天的内容
        // 如果参数为 20170419
        // 那么返回的为 20170418 的内容
        String date = StringUtils.dateString(page - 1);
        mRetrofitHttpHelper
                .getService()
                .getBeforeMessage(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(response -> CacheManager.saveBeforeMessage(App.getContext(), response, date))
                .doOnError(throwable -> {
                    if (CacheManager.hasBeforeMessage(App.getContext(), date)) {
                        BeforeMessageResponse response = CacheManager.getBeforeMessage(App.getContext(), date);
                        subscriber.onNext(response);
                    }
                })
                .subscribe(subscriber);
    }


    public static void getLongComment(String id, Subscriber<LongCommentResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getLongComment(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public static void getShortComment(String id, Subscriber<ShortCommentResponse> subscriber) {
        mRetrofitHttpHelper
                .getService()
                .getShortComment(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public static void downloadFile(@NonNull String url, @NonNull File des) {
        mExtraHttpHelper
                .getService()
                .downloadFile(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .doOnNext(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        Log.d(TAG, "call: ");
                    }
                })
                .subscribe();
    }

}
