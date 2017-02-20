package top.wuhaojie.zhd.home.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import top.wuhaojie.lib.list.OnLoadMoreListener;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseFragment;
import top.wuhaojie.zhd.home.main.adapter.MainContentListAdapter;

import static android.content.ContentValues.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment implements MainFragmentView {

    MainFragmentPresenter mMainFragmentPresenter;
    @BindView(R.id.rv_content_main)
    RecyclerView mRvContentMain;
    @BindView(R.id.srf_main)
    SwipeRefreshLayout mSrfMain;
    private MainContentListAdapter mMainContentListAdapter;
    private OnLoadMoreListener mOnLoadMoreListener;

    public MainFragment() {
        Log.d(TAG, "MainFragment: new Instance");
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainFragmentPresenter = new MainFragmentPresenter(getActivity());
        mMainFragmentPresenter.bindView(this);

        mSrfMain.setOnRefreshListener(() -> mMainFragmentPresenter.onRefresh());


        mMainContentListAdapter = new MainContentListAdapter(mActivity);
        mMainContentListAdapter.setOnItemClickListener(item -> mMainFragmentPresenter.onMainContentListItemClick(item));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        mRvContentMain.setLayoutManager(linearLayoutManager);
        mRvContentMain.setAdapter(mMainContentListAdapter);
        mOnLoadMoreListener = new OnLoadMoreListener() {
            @Override
            protected void onLoadMore(int page) {
                mMainFragmentPresenter.onLoadMore(page);
            }
        };
        mRvContentMain.addOnScrollListener(mOnLoadMoreListener);

        mMainFragmentPresenter.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
//        mBannerHot.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
//        mBannerHot.stopAutoPlay();
    }


    @Override
    public int getLayoutResID() {
        return R.layout.fragment_main;
    }

    @Override
    public void setBanner(List<MainContentListAdapter.Item> list) {
        mMainContentListAdapter.setBannerList(list);
    }

    @Override
    public void resetPage() {
        if (mOnLoadMoreListener != null) mOnLoadMoreListener.resetPage();
    }

    @Override
    public void loadCompleted() {
        mSrfMain.setRefreshing(false);
    }

    @Override
    public void setListContent(List<MainContentListAdapter.Item> items) {
        mMainContentListAdapter.setStoryList(items);
    }

    @Override
    public void appendListContent(List<MainContentListAdapter.Item> items, String indexTitle) {
        mMainContentListAdapter.append(items, indexTitle);
    }


}
