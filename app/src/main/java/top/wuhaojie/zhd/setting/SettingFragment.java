package top.wuhaojie.zhd.setting;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;

import top.wuhaojie.zhd.R;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/02/20 13:51
 * Version: 1.0
 */

public class SettingFragment extends PreferenceFragment {

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addPreferencesFromResource(R.xml.pref_setting);
    }
}
