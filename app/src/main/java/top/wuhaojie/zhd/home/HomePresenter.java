package top.wuhaojie.zhd.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.setting.SettingActivity;

import static top.wuhaojie.zhd.home.HomeNavigationAdapter.*;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class HomePresenter implements BasePresenter {

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
        ArrayList<Item> list = new ArrayList<>();
        Item<Home> item = new Item<>(TYPE_HOME, null);
        list.add(item);

//        list.add(new Item<>(TYPE_OTHERS, new Others()));
//        list.add(new Item<>(TYPE_OTHERS, new Others()));
//        list.add(new Item<>(TYPE_OTHERS, new Others()));

        mView.setNavAdapterList(list);

    }
}
