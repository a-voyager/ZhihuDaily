package top.wuhaojie.zhd.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Created by wuhaojie on 17-2-9.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResID(), container, false);
    }

}
