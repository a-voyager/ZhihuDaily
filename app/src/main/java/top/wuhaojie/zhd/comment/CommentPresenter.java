package top.wuhaojie.zhd.comment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.comment.adapter.CommentListAdapter.ShortCommentData;
import top.wuhaojie.zhd.constant.Constants;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.LongCommentResponse;
import top.wuhaojie.zhd.entities.ShortCommentResponse;

import static top.wuhaojie.zhd.comment.adapter.CommentListAdapter.IndexData;
import static top.wuhaojie.zhd.comment.adapter.CommentListAdapter.Item;
import static top.wuhaojie.zhd.comment.adapter.CommentListAdapter.LongCommentData;
import static top.wuhaojie.zhd.comment.adapter.CommentListAdapter.TYPE_INDEX;
import static top.wuhaojie.zhd.comment.adapter.CommentListAdapter.TYPE_LONG_COMMENT;
import static top.wuhaojie.zhd.comment.adapter.CommentListAdapter.TYPE_NO_LONG_COMMENT;
import static top.wuhaojie.zhd.comment.adapter.CommentListAdapter.TYPE_SHORT_COMMENT;

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
    private String mCommentNumber;
    private int mLastSize;

    public CommentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (CommentView) view;
    }

    public void onCreate(Bundle savedInstanceState, Intent intent) {
        if (intent != null) {
            mCommentNumber = intent.getStringExtra(Constants.INTENT_EXTRA_COMMENT_NUMBER);
            mView.updateToolbar(mCommentNumber);
            mStoryId = intent.getStringExtra(Constants.INTENT_EXTRA_STORY_ID);
        }
        mView.showWaitDialog();
        HttpUtils.getLongComment(mStoryId, new Subscriber<LongCommentResponse>() {
            @Override
            public void onCompleted() {
                mView.dismissWaitDialog();
            }

            @Override
            public void onError(Throwable e) {
                mView.dismissWaitDialog();
            }

            @Override
            public void onNext(LongCommentResponse longCommentResponse) {
                Log.d(TAG, "onNext: " + longCommentResponse);
                handleLongResult(longCommentResponse);
            }
        });


    }

    private void handleLongResult(LongCommentResponse longCommentResponse) {
        // result
        ArrayList<Item<?>> items = new ArrayList<>();
        // fill
        fillData(longCommentResponse, items);
        // ui
        mView.updateList(items);
    }

    private void fillData(LongCommentResponse longCommentResponse, ArrayList<Item<?>> items) {
        // source
        List<LongCommentResponse.CommentsBean> comments = longCommentResponse.getComments();
        // long index
        int size = comments.size();
        items.add(new Item<>(TYPE_INDEX, new IndexData(size + "条长评", false)));
        if (size == 0) items.add(new Item<>(TYPE_NO_LONG_COMMENT, null));

        // long data
        for (LongCommentResponse.CommentsBean comment : comments) {
            LongCommentData data = new LongCommentData(
                    "" + comment.getId(),
                    comment.getAuthor(),
                    comment.getAvatar(),
                    comment.getContent(),
                    comment.getLikes(),
                    comment.getTime()
            );
            Item<LongCommentData> item = new Item<>(TYPE_LONG_COMMENT, data);
            items.add(item);
        }

        // short index
        int shortCommentNumber = Integer.valueOf(mCommentNumber) - size;
        items.add(new Item<>(TYPE_INDEX, new IndexData(shortCommentNumber + "条短评", true)));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) mView.back();
        return true;
    }

    /**
     * @param v      item view
     * @param folded new state
     */
    public void onIndexClickListener(View v, boolean folded) {
        if (!folded) {
            // load data
            mView.showWaitDialog();
            HttpUtils.getShortComment(mStoryId, new Subscriber<ShortCommentResponse>() {
                @Override
                public void onCompleted() {
                    mView.dismissWaitDialog();
                }

                @Override
                public void onError(Throwable e) {
                    mView.dismissWaitDialog();
                }

                @Override
                public void onNext(ShortCommentResponse shortCommentResponse) {
                    handleShortResult(shortCommentResponse);
                }
            });
        } else {
            // remove data
            if (mLastSize > 0) {
                mView.removeList(mLastSize);
            }
        }
    }

    private void handleShortResult(ShortCommentResponse shortCommentResponse) {
        // result
        ArrayList<Item<?>> items = new ArrayList<>();
        // fill
        List<ShortCommentResponse.CommentsBean> comments = shortCommentResponse.getComments();
        for (ShortCommentResponse.CommentsBean comment : comments) {
            ShortCommentData shortCommentData = new ShortCommentData(
                    comment.getId() + "",
                    comment.getAuthor(),
                    comment.getAvatar(),
                    comment.getContent(),
                    comment.getLikes(),
                    comment.getTime()
            );
            Item<ShortCommentData> item = new Item<>(TYPE_SHORT_COMMENT, shortCommentData);
            items.add(item);
        }
        // save item size
        mLastSize = items.size();
        // ui
        mView.appendList(items);
    }
}
