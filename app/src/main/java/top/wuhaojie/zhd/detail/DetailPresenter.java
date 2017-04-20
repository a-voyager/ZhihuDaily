package top.wuhaojie.zhd.detail;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.manager.IntentManager;

/**
 * Created by wuhaojie on 17-2-11.
 */

public class DetailPresenter implements BasePresenter {

    private DetailView mView;
    private Context mContext;
    private String mCommentNumber;
    private String mPraiseNumber;

    public DetailPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (DetailView) view;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) mView.back();
        return true;
    }

    public boolean onCommentMenuItemClick(MenuItem item) {
        Intent intent = IntentManager.toCommentActivity(mContext, currStoryId(), mCommentNumber);
        mContext.startActivity(intent);
        return true;
    }

    public boolean onPraiseMenuItemClick(MenuItem item) {
        return false;
    }

    private String currStoryId() {
        return mView.currStoryId();
    }

    public void refreshToolBar(String commentNumber, String praiseNumber) {
        mCommentNumber = commentNumber;
        mPraiseNumber = praiseNumber;
    }

    public void onDestroy() {
        mView.dispose();
    }
}
