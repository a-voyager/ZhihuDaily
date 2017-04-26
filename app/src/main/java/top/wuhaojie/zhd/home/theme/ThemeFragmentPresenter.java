package top.wuhaojie.zhd.home.theme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import rx.Subscriber;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.ThemesResponse;
import top.wuhaojie.zhd.home.theme.adapter.EditorsAdapter;
import top.wuhaojie.zhd.home.theme.editors.EditorsActivity;
import top.wuhaojie.zhd.manager.IntentManager;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/25 21:14
 * Version: 1.0
 */

public class ThemeFragmentPresenter implements BasePresenter {

    private Context mContext;
    private ThemeFragmentView mView;
    private ArrayList<EditorsAdapter.Item> mList;

    public ThemeFragmentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (ThemeFragmentView) view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState, ThemeFragment.Argument argument) {
        mView.fillView(argument.name, argument.description, argument.thumbnail);

        HttpUtils.getThemes(String.valueOf(argument.id), new Subscriber<ThemesResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ThemesResponse themesResponse) {
                handleResult(themesResponse);
            }
        });

        mList = new ArrayList<>();
        mList.add(new EditorsAdapter.Item("", "", 0, "http://pic4.zhimg.com/40f7ca4a683566acbe16a30a4992a943_m.jpg", ""));
        mList.add(new EditorsAdapter.Item("", "", 0, "http://pic4.zhimg.com/40f7ca4a683566acbe16a30a4992a943_m.jpg", ""));
        mList.add(new EditorsAdapter.Item("", "", 0, "http://pic4.zhimg.com/40f7ca4a683566acbe16a30a4992a943_m.jpg", ""));

        mView.setEditorsList(mList);

    }

    private void handleResult(ThemesResponse themesResponse) {

    }

    public void onEditorsClick() {
        if (mList == null) return;
        ArrayList<EditorsActivity.Argument> arguments = new ArrayList<>();
        for (EditorsAdapter.Item item : mList) {
            EditorsActivity.Argument argument = new EditorsActivity.Argument(item.url, item.bio, item.id, item.avatar, item.name);
            arguments.add(argument);
        }
        Intent intent = IntentManager.toEditorsActivity(mContext, arguments);
        mContext.startActivity(intent);
    }
}
