package top.wuhaojie.zhd.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.manager.IntentManager;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/22 16:20
 * Version: 1.0
 */

public class SplashPresenter implements BasePresenter {

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
    }
}
