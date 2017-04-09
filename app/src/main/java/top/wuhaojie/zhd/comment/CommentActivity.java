package top.wuhaojie.zhd.comment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;
import top.wuhaojie.zhd.comment.adapter.CommentListAdapter;

public class CommentActivity extends BaseActivity implements CommentView {


    private static final String TAG = "CommentActivity";
    @BindView(R.id.rv_content_comment)
    RecyclerView mRvContentComment;
    private CommentPresenter mPresenter;
    private ProgressDialog mProgressDialog;
    private CommentListAdapter mCommentListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new CommentPresenter(this);
        mPresenter.bindView(this);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCommentListAdapter = new CommentListAdapter(this);
        mCommentListAdapter.setOnIndexClickListener((v, folded) -> mPresenter.onIndexClickListener(v, folded));
        mCommentListAdapter.setOnCommentClickListner((v, type, id) -> mPresenter.OnCommentClick(v, type, id));

        mRvContentComment.setLayoutManager(new LinearLayoutManager(this));
        mRvContentComment.setAdapter(mCommentListAdapter);
        mRvContentComment.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mPresenter.onCreate(savedInstanceState, getIntent());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_comment, menu);
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public void updateList(ArrayList<CommentListAdapter.Item<?>> items) {
        mCommentListAdapter.setList(items);
    }

    @Override
    public void appendList(ArrayList<CommentListAdapter.Item<?>> items) {
        int lastPosition = mCommentListAdapter.getListSize() - 1;
        mCommentListAdapter.appendList(items);
        int visibleChildCount = mRvContentComment.getChildCount();
        mRvContentComment.smoothScrollToPosition(lastPosition + visibleChildCount);
    }

    @Override
    public void removeList(int lastSize) {
        mCommentListAdapter.removeList(lastSize);
    }

    @Override
    public void showContextDialog(String[] items, int type, String id) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setItems(items, (d, which) -> mPresenter.onContextDialogClick(which))
                .create();
        dialog.show();
    }

    private void checkAndInitProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("努力加载中");
        }
    }
}
