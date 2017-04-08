package top.wuhaojie.zhd.comment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;

public class CommentActivity extends BaseActivity implements CommentView {


    private CommentPresenter mPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new CommentPresenter(this);
        mPresenter.bindView(this);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mPresenter.onCreate(savedInstanceState, getIntent());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mPresenter.onOptionsItemSelected(item);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_comment;
    }

    @Override
    public void updateToolbar(String commentNumber) {
        String title = commentNumber + "条点评";
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(title);
    }

    @Override
    public void back() {
        finish();
    }

    @Override
    public void showWaitDialog() {
        checkAndInitProgressDialog();
        mProgressDialog.show();
    }

    @Override
    public void dismissWaitDialog() {
        checkAndInitProgressDialog();
        mProgressDialog.dismiss();
    }

    private void checkAndInitProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("努力加载中");
        }
    }
}
