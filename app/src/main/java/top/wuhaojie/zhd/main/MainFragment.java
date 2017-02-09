package top.wuhaojie.zhd.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment {

    MainFragmentPresenter mMainFragmentPresenter;

    public MainFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMainFragmentPresenter = new MainFragmentPresenter(getActivity());
        mMainFragmentPresenter.bindView(this);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_main;
    }
}
