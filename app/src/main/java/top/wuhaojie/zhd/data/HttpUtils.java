package top.wuhaojie.zhd.data;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import top.wuhaojie.lib.http.RetrofitHttpHelper;
import top.wuhaojie.zhd.App;
import top.wuhaojie.zhd.data.api.APIService;
import top.wuhaojie.zhd.entities.BeforeMessageResponse;
import top.wuhaojie.zhd.entities.DetailMessageResponse;
import top.wuhaojie.zhd.entities.LatestMessageResponse;
import top.wuhaojie.zhd.entities.LongCommentResponse;
import top.wuhaojie.zhd.entities.ShortCommentResponse;
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
        mRetrofitHttpHelper
                .getService()
                .getBeforeMessage(StringUtils.dateString(page))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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

}
