package top.wuhaojie.zhd.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;

public class MainActivity extends BaseActivity {

    MainActivityPresenter mMainPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = new MainActivityPresenter(this);
        mMainPresenter.bindView(this);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

}
