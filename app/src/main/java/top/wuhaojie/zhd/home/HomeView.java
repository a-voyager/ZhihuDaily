package top.wuhaojie.zhd.home;

import java.util.ArrayList;

import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/25 19:44
 * Version: 1.0
 */

public interface HomeView extends BaseView {
    void setNavAdapterList(ArrayList<HomeNavigationAdapter.Item> list);

    void switch2Main();

    void switch2Theme(HomeNavigationAdapter.Others o);

    void closeDrawer();
}
