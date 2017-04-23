package top.wuhaojie.zhd.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.StartImageResponse;
import top.wuhaojie.zhd.manager.IntentManager;
import top.wuhaojie.zhd.manager.SplashManager;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/22 16:20
 * Version: 1.0
 */

public class SplashPresenter implements BasePresenter {

    private static final String TAG = "SplashPresenter";
    private SplashView mView;
    private Context mContext;

    public SplashPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (SplashView) view;
    }

    public void onCreate(Bundle savedInstanceState) {
        Observable
                .timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(() -> {
                    Intent intent = IntentManager.toMainActivity(mContext);
                    mContext.startActivity(intent);
                    mView.finishActivity();
                })
                .subscribe();
        // load splash image
        String uri = SplashManager.load();
        if (!TextUtils.isEmpty(uri)) {
            mView.loadImage(uri);
        }

        // update new image
        Point point = new Point(1080, 1920);
        mView.getScreenSize(point);
        int width = point.x;
        int height = (int) (point.y * 0.9);
        HttpUtils
                .getStartImage(width, height, new Subscriber<StartImageResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(StartImageResponse response) {
                        List<StartImageResponse.CreativesBean> list = response.getCreatives();
                        StartImageResponse.CreativesBean cb = list.get(0);
                        SplashManager.save(cb.getId(), cb.getUrl());
                    }
                });
    }
}
