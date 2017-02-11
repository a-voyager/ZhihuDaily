package top.wuhaojie.zhd.home.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.List;

import butterknife.BindView;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseFragment;
import top.wuhaojie.zhd.home.main.adapter.MainContentListAdapter;
import top.wuhaojie.zhd.utils.BannerImageLoader;

import static android.content.ContentValues.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment implements MainFragmentView {

    MainFragmentPresenter mMainFragmentPresenter;
    @BindView(R.id.banner_hot)
    Banner mBannerHot;
    @BindView(R.id.rv_content_main)
    RecyclerView mRvContentMain;
    @BindView(R.id.srf_main)
    SwipeRefreshLayout mSrfMain;
    private MainContentListAdapter mMainContentListAdapter;

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

        mBannerHot
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setDelayTime(4000)
                .setImageLoader(new BannerImageLoader())
                .isAutoPlay(true)
                .start();


        mMainContentListAdapter = new MainContentListAdapter(mActivity);
        mMainContentListAdapter.setOnItemClickListener(item -> mMainFragmentPresenter.onMainContentListItemClick(item));

        mRvContentMain.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvContentMain.setAdapter(mMainContentListAdapter);


        mMainFragmentPresenter.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBannerHot.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBannerHot.stopAutoPlay();
    }


    @Override
    public int getLayoutResID() {
        return R.layout.fragment_main;
    }

    @Override
    public void setBanner(List<String> images, List<String> titles) {
        mBannerHot
                .setImages(images)
                .setBannerTitles(titles)
                .start();
    }

    @Override
    public void loadCompleted() {
        mSrfMain.setRefreshing(false);
    }

    @Override
    public void setListContent(List<MainContentListAdapter.Item> items) {
        mMainContentListAdapter.setList(items);
    }
}
