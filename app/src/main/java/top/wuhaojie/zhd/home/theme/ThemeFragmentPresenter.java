package top.wuhaojie.zhd.home.theme;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/25 21:14
 * Version: 1.0
 */

public class ThemeFragmentPresenter implements BasePresenter {

    private Context mContext;
    private ThemeFragmentView mView;

    public ThemeFragmentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (ThemeFragmentView) view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState, ThemeFragment.Argument argument) {
        mView.fillView(argument.name, argument.description, argument.thumbnail);
    }
}
