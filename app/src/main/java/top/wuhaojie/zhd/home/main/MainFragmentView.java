package top.wuhaojie.zhd.home.main;

import java.util.List;

import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Created by wuhaojie on 17-2-9.
 */

public interface MainFragmentView extends BaseView {
    void setBanner(List<String> images, List<String> titles);

    void loadCompleted();
}
