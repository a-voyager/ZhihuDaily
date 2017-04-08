package top.wuhaojie.zhd.comment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.constant.Constants;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 19:02
 * Version: 1.0
 */

public class CommentPresenter implements BasePresenter {

    private static final String TAG = "CommentPresenter";
    private CommentView mView;
    private Context mContext;
    private String mStoryId;

    public CommentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (CommentView) view;
    }

    public void onCreate(Bundle savedInstanceState, Intent intent) {
        if (intent != null) {
            String commentNumber = intent.getStringExtra(Constants.INTENT_EXTRA_COMMENT_NUMBER);
            mView.updateToolbar(commentNumber);
            mStoryId = intent.getStringExtra(Constants.INTENT_EXTRA_STORY_ID);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) mView.back();
        return true;
    }
}
