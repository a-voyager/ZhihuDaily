package top.wuhaojie.zhd.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhaojie on 17-2-12.
 */

public class DetailContentAdapter extends FragmentStatePagerAdapter {

    private List<String> mStoryIds = new ArrayList<>();

    public void setStoryIds(List<String> list) {
        mStoryIds.clear();
        mStoryIds.addAll(list);
        notifyDataSetChanged();
    }

    public void appendStoryIds(List<String> list) {
        mStoryIds.addAll(list);
        notifyDataSetChanged();
    }


    public String getStoryId(int currItem) {
        return mStoryIds.get(currItem);
    }

    public DetailContentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DetailContentFragment.newInstance(mStoryIds.get(position));
    }

    @Override
    public int getCount() {
        return mStoryIds.size();
    }
}
