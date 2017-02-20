package top.wuhaojie.zhd.home;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.setting.SettingActivity;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class HomePresenter implements BasePresenter {

    private Context mContext;

    public HomePresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {

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
}
