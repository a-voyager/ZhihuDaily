package top.wuhaojie.zhd.home.theme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import butterknife.BindView;
import top.wuhaojie.lib.image.ImageLoader;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseFragment;
import top.wuhaojie.zhd.home.HomeActivity;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/25 21:13
 * Version: 1.0
 */

public class ThemeFragment extends BaseFragment implements ThemeFragmentView {

    public static final String KEY_ARGUMENT = "ARGUMENT";
    @BindView(R.id.tv_description)
    TextView mTvDescription;
    @BindView(R.id.rv_editors)
    RecyclerView mRvEditors;
    @BindView(R.id.rv_content)
    RecyclerView mRvContent;
    @BindView(R.id.iv_thumbnail)
    ImageView mIvThumbnail;
    private ThemeFragmentPresenter mPresenter;

    @Override
    public void fillView(String name, String description, String thumbnail) {
        HomeActivity activity = (HomeActivity) mActivity;
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setTitle(name);
        }
        mTvDescription.setText(description);
        ImageLoader.get().load(thumbnail, mIvThumbnail);
    }


    public static class Argument implements Serializable {

        private static final long serialVersionUID = 7802201238441662100L;

        int color;
        String thumbnail;
        String description;
        int id;
        String name;

        public Argument(int color, String thumbnail, String description, int id, String name) {
            this.color = color;
            this.thumbnail = thumbnail;
            this.description = description;
            this.id = id;
            this.name = name;
        }
    }

    public static ThemeFragment newInstance(Argument argument) {
        ThemeFragment fragment = new ThemeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_ARGUMENT, argument);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_theme;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new ThemeFragmentPresenter(mActivity);
        mPresenter.bindView(this);

        Bundle bundle = getArguments();
        Argument argument = (Argument) bundle.getSerializable(KEY_ARGUMENT);
        mPresenter.onViewCreated(view, savedInstanceState, argument);
    }
}
