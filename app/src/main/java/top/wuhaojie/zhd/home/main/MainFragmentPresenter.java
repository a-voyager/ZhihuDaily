package top.wuhaojie.zhd.home.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import top.wuhaojie.zhd.base.interfaces.BasePresenter;
import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.LatestMessageResponse;
import top.wuhaojie.zhd.home.main.adapter.MainContentListAdapter;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class MainFragmentPresenter implements BasePresenter {

    private static final String TAG = "MainFragmentPresenter";
    private Context mContext;
    private MainFragmentView mView;

    public MainFragmentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void bindView(BaseView view) {
        mView = (MainFragmentView) view;
    }

    private void loadData() {
        HttpUtils.getLatestMessages(new Subscriber<LatestMessageResponse>() {
            @Override
            public void onCompleted() {
                mView.loadCompleted();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
            }

            @Override
            public void onNext(LatestMessageResponse latestMessageResponse) {
                Log.d(TAG, "onNext: Message = " + latestMessageResponse);
                List<LatestMessageResponse.TopStoriesBean> topStories = latestMessageResponse.getTop_stories();
                ArrayList<String> images = new ArrayList<>();
                ArrayList<String> titles = new ArrayList<>();
                for (LatestMessageResponse.TopStoriesBean story : topStories) {
                    String image = story.getImage();
                    String title = story.getTitle();
                    images.add(image);
                    titles.add(title);
                }
                mView.setBanner(images, titles);

                List<LatestMessageResponse.StoriesBean> stories = latestMessageResponse.getStories();
                ArrayList<MainContentListAdapter.Item> items = new ArrayList<>();
                for (LatestMessageResponse.StoriesBean st : stories) {
                    MainContentListAdapter.Item item = new MainContentListAdapter.Item();
                    item.title = st.getTitle();
                    item.imgUrl = st.getImages().get(0);
                    item.id = st.getId();
                    items.add(item);
                }
                mView.setListContent(items);
            }
        });
    }

    public void onRefresh() {
        loadData();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        loadData();
    }
}
