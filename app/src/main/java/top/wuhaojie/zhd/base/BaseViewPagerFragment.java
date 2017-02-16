package top.wuhaojie.zhd.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/02/16 13:15
 * Version: 1.0
 */

public abstract class BaseViewPagerFragment extends BaseFragment {

    private boolean isViewInited = false;
    private boolean isViewVisible = false;
    private boolean isLoaded = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInited = true;
        prepareLoadData(true);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isViewVisible = isVisibleToUser;
        prepareLoadData(true);
    }

    private void prepareLoadData(boolean force) {
        if (isViewVisible && isViewInited && (!isLoaded || force)) {
            loadData();
            isLoaded = true;
        }
    }

    protected abstract void loadData();
}
