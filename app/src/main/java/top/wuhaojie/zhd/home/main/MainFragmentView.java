package top.wuhaojie.zhd.home.main;

import java.util.List;

import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.home.main.adapter.MainContentListAdapter;

/**
 * Created by wuhaojie on 17-2-9.
 */

public interface MainFragmentView extends BaseView {
    void setBanner(List<String> images, List<String> titles);

    void loadCompleted();

    void setListContent(List<MainContentListAdapter.Item> items);
}
