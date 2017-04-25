package top.wuhaojie.zhd.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.ThemesListResponse;
import top.wuhaojie.zhd.setting.SettingActivity;

import static top.wuhaojie.zhd.home.HomeNavigationAdapter.*;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class HomePresenter implements BasePresenter, OnNavItemClickListener {

    private static final String TAG = "HomePresenter";
    private Context mContext;
    private HomeView mView;

    public HomePresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (HomeView) view;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Intent intent = new Intent(mContext, SettingActivity.class);
                mContext.startActivity(intent);
                break;
        }
        return true;
    }

    public void onCreate(Bundle savedInstanceState) {

        HttpUtils.getThemesList(new Subscriber<ThemesListResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ThemesListResponse response) {
                handleResult(response);
            }
        });

    }

    private void handleResult(ThemesListResponse response) {
        ArrayList<HomeNavigationAdapter.Item> list = new ArrayList<>();
        HomeNavigationAdapter.Item<HomeNavigationAdapter.Home> item = new HomeNavigationAdapter.Item<>(TYPE_HOME, null);
        list.add(item);


        List<ThemesListResponse.OthersBean> others = response.getOthers();
        for (ThemesListResponse.OthersBean o : others) {
            Others otherInItem = new Others(o.getColor(), o.getThumbnail(), o.getDescription(), o.getId(), o.getName());
            Item<Others> oItem = new Item<>(TYPE_OTHERS, otherInItem);
            list.add(oItem);
        }

        mView.setNavAdapterList(list);

    }

    @Override
    public void onHomeItemClick() {
        mView.switch2Main();
    }

    @Override
    public void onOthersThemeFollowClick(Others o) {
        Log.d(TAG, "onOthersThemeFollowClick: " + o);
    }

    @Override
    public void onOthersThemeClick(Others o) {
        Log.d(TAG, "onOthersThemeClick: " + o);
    }
}
