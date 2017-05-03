package top.wuhaojie.zhd.splash;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.wuhaojie.lib.image.ImageLoader;
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

        Animation scale = AnimationUtils.loadAnimation(this, R.anim.alpha);
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

    @Override
    public void getScreenSize(@NonNull Point point) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindow().getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            Display display = getWindow().getWindowManager().getDefaultDisplay();
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
    }

    @Override
    public void loadImage(String uri) {
        ImageLoader.get().load(uri, mIvSplash);
    }
}
