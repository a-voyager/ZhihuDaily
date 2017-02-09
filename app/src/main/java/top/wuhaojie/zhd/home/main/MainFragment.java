package top.wuhaojie.zhd.home.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment implements MainFragmentView {

    MainFragmentPresenter mMainFragmentPresenter;

    public MainFragment() {
        Log.d(TAG, "MainFragment: new Instance");
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainFragmentPresenter = new MainFragmentPresenter(getActivity());
        mMainFragmentPresenter.bindView(this);
    }

    @Override
    protected void loadData() {
        mMainFragmentPresenter.loadData();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_main;
    }
}
