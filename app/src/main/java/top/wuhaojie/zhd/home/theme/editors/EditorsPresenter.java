package top.wuhaojie.zhd.home.theme.editors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.constant.Constants;
import top.wuhaojie.zhd.home.theme.adapter.EditorsAdapter;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/26 13:11
 * Version: 1.0
 */

public class EditorsPresenter implements BasePresenter {

    private static final String TAG = "EditorsPresenter";
    private Context mContext;
    private EditorsView mView;

    public EditorsPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (EditorsView) view;
    }

    public void onCreate(Bundle savedInstanceState, Intent intent) {
        if (intent != null) {
            ArrayList<EditorsActivity.Argument> editors = intent.getParcelableArrayListExtra(Constants.INTENT_EXTRA_EDITORS_LIST);
            ArrayList<EditorsAdapter.Item> items = new ArrayList<>();
            for (EditorsActivity.Argument argument : editors) {
                EditorsAdapter.Item item = new EditorsAdapter.Item(argument.url, argument.bio, argument.id, argument.avatar, argument.name);
                items.add(item);
            }
            mView.setEditorsList(items);
            Log.d(TAG, "onCreate: ");
        }
    }
}
