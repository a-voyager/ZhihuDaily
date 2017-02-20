package top.wuhaojie.zhd.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;

public class SettingActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.content, SettingFragment.newInstance())
                .commit();
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return true;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_setting;
    }
}
