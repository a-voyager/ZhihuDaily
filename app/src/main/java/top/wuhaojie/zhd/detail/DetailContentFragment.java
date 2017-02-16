package top.wuhaojie.zhd.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;
import top.wuhaojie.lib.image.ImageLoader;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseViewPagerFragment;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.DetailMessageResponse;
import top.wuhaojie.zhd.entities.StoryExtraResponse;

public class DetailContentFragment extends BaseViewPagerFragment {
    private static final String ARG_STORY_ID = "param_id";
    private static final String TAG = "DetailContentFragment";
    @BindView(R.id.iv_big_img)
    ImageView mIvBigImg;
    @BindView(R.id.tv_source)
    TextView mTvSource;
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private String mStoryId;

    private OnFragmentInteractionListener mListener;

    public static DetailContentFragment newInstance(String id) {
        DetailContentFragment fragment = new DetailContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STORY_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStoryId = getArguments().getString(ARG_STORY_ID);
        }
    }


    public void onUpdateToolBar(String commentNumber, String praiseNumber) {
        if (mListener != null) {
            mListener.refreshToolBar(commentNumber, praiseNumber);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_detail_content;
    }

    @Override
    protected void loadData() {
        loadContent();
        loadToolBar();
    }


    public interface OnFragmentInteractionListener {
        void refreshToolBar(String commentNumber, String praiseNumber);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void loadToolBar() {
        onUpdateToolBar("...", "...");
        if (TextUtils.isEmpty(mStoryId)) {
            throw new NullPointerException("story id is null");
        }
        HttpUtils.getStoryExtra(mStoryId, new Subscriber<StoryExtraResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StoryExtraResponse storyExtraResponse) {
                int comments = storyExtraResponse.getComments();
                int popularity = storyExtraResponse.getPopularity();
                onUpdateToolBar(comments + "", popularity + "");
            }
        });
    }

    private void loadContent() {
        if (TextUtils.isEmpty(mStoryId)) {
            throw new NullPointerException("story id is null");
        }
        HttpUtils.getDetailMessage(mStoryId, new Subscriber<DetailMessageResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DetailMessageResponse detailMessageResponse) {
                Log.d(TAG, "onNext: " + detailMessageResponse);
                inflateData(detailMessageResponse);
            }
        });
    }

    private void inflateData(DetailMessageResponse detailMessageResponse) {
        String title = detailMessageResponse.getTitle();
        mTvTitle.setText(title);

        String imageSource = detailMessageResponse.getImage_source();
        mTvSource.setText(imageSource);

        String imageUrl = detailMessageResponse.getImage();
        ImageLoader.get().load(imageUrl, mIvBigImg);

        String body = detailMessageResponse.getBody();

        List<String> css = detailMessageResponse.getCss();

        List<String> js = detailMessageResponse.getJs();

        String shareUrl = detailMessageResponse.getShare_url();

    }
}
