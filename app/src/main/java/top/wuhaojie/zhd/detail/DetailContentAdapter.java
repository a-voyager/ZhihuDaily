package top.wuhaojie.zhd.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by wuhaojie on 17-2-12.
 */

public class DetailContentAdapter extends FragmentStatePagerAdapter {

    public DetailContentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DetailContentFragment.newInstance("a", "b");
    }

    @Override
    public int getCount() {
        return 6;
    }
}
