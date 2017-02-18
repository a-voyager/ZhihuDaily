package top.wuhaojie.lib.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/02/18 23:16
 * Version: 1.0
 */

public abstract class OnLoadMoreListener extends RecyclerView.OnScrollListener {


    private boolean mLoaded = true;
    private int mLastTotalCount = 0;
    private int mCurrPage = 0;
    private LinearLayoutManager mLayoutManager;
    private boolean mIsScrolling;

    public OnLoadMoreListener(LinearLayoutManager layoutManager) {
        mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int visibleCount = recyclerView.getChildCount();
//        mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (!mIsScrolling) return;
        int totalCount = mLayoutManager.getItemCount();
        int firstVisiblePosition = mLayoutManager.findFirstVisibleItemPosition();

        if (mLoaded && mLastTotalCount < totalCount) {
            // 如果 已经加载完毕
            // 并且 最后一次检测到的数值小于当前数值
            // 更新当前值
            mLoaded = false;
            mLastTotalCount = totalCount;
        }

        if (!mLoaded && (totalCount - visibleCount) <= firstVisiblePosition) {
            // 如果 总数 < = 可见数目 + 第一个可见序号（前面的不可见数目）
            mCurrPage++;
            onLoadMore(mCurrPage);
            mLoaded = true;
        }

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        mIsScrolling = (newState != RecyclerView.SCROLL_STATE_IDLE);
    }

    protected abstract void onLoadMore(int page);
}
