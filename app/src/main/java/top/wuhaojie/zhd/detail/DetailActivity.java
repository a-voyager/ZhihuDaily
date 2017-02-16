package top.wuhaojie.zhd.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;
import top.wuhaojie.zhd.constant.Constants;

public class DetailActivity extends BaseActivity implements DetailView, DetailContentFragment.OnFragmentInteractionListener {

    DetailPresenter mDetailPresenter;
    @BindView(R.id.vp_detail_content)
    ViewPager mVpDetailContent;
    private TextView mCommentNumber;
    private TextView mPraiseNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailPresenter = new DetailPresenter(this);
        mDetailPresenter.bindView(this);


        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DetailContentAdapter detailContentAdapter = new DetailContentAdapter(getSupportFragmentManager());
        mVpDetailContent.setAdapter(detailContentAdapter);

        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<String> list = intent.getStringArrayListExtra(Constants.INTENT_EXTRA_STORY_IDS);
            detailContentAdapter.setStoryIds(list);

            String currId = intent.getStringExtra(Constants.INTENT_EXTRA_STORY_CURRENT_ID);
            for (int i = 0; i < list.size(); i++) {
                if (currId.equals(list.get(i))) {
                    mVpDetailContent.setCurrentItem(i);
                    break;
                }
            }
        }

    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_detail;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem comment = menu.findItem(R.id.action_comment);
        comment.setActionView(R.layout.action_comment);
        comment.setOnMenuItemClickListener(item -> mDetailPresenter.onCommentMenuItemClick(item));
        mCommentNumber = (TextView) comment.getActionView().findViewById(R.id.tv_comment_number);
        MenuItem praise = menu.findItem(R.id.action_praise);
        praise.setActionView(R.layout.action_praise);
        praise.setOnMenuItemClickListener(item -> mDetailPresenter.onPraiseMenuItemClick(item));
        mPraiseNumber = (TextView) praise.getActionView().findViewById(R.id.tv_praise_number);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDetailPresenter.onOptionsItemSelected(item);
    }

    @Override
    public void back() {
        finish();
        // TODO: 17-2-11 记录阅读进度
    }

    @Override
    public void refreshToolBar(String commentNumber, String praiseNumber) {
        if (mCommentNumber == null || mPraiseNumber == null) return;
        if (TextUtils.isEmpty(commentNumber) || TextUtils.isEmpty(praiseNumber))
            throw new NullPointerException("commentNumber is null or praiseNumber is null");
        mCommentNumber.setText(commentNumber);
        mPraiseNumber.setText(praiseNumber);
    }
}
