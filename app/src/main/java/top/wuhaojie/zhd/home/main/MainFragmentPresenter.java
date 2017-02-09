package top.wuhaojie.zhd.home.main;

import android.content.Context;

import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class MainFragmentPresenter implements BasePresenter {

    private Context mContext;
    private MainFragmentView mView;

    public MainFragmentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (MainFragmentView) view;
    }

    public void loadData() {

    }
}
