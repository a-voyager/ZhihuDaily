package top.wuhaojie.zhd.detail;

import android.content.Context;
import android.view.MenuItem;

import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Created by wuhaojie on 17-2-11.
 */

public class DetailPresenter implements BasePresenter {

    private DetailView mView;
    private Context mContext;

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
        return false;
    }

    public boolean onPraiseMenuItemClick(MenuItem item) {
        return false;
    }
}
