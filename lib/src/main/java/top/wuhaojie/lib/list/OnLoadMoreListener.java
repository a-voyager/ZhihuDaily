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


    private static final String TAG = "OnLoadMoreListener";
    private boolean mLoaded = true;
    private int mLastTotalCount = 0;
    private int mCurrPage = -1;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int visibleCount = recyclerView.getChildCount();
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int totalCount = layoutManager.getItemCount();
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();

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
    }

    protected abstract void onLoadMore(int page);
}
