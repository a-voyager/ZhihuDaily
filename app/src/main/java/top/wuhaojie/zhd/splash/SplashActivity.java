package top.wuhaojie.zhd.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.wuhaojie.zhd.R;

public class SplashActivity extends AppCompatActivity implements SplashView {


    @BindView(R.id.iv_splash)
    ImageView mIvSplash;
    @BindView(R.id.ll_logo)
    LinearLayout mLlLogo;
    private SplashPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        ButterKnife.bind(this);

        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        mIvSplash.startAnimation(scale);

        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        mLlLogo.startAnimation(alpha);


        mPresenter = new SplashPresenter(this);
        mPresenter.bindView(this);
        mPresenter.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_splash;
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
