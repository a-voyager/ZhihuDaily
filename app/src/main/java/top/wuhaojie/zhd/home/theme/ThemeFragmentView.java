package top.wuhaojie.zhd.home.theme;

import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/25 21:14
 * Version: 1.0
 */

public interface ThemeFragmentView extends BaseView {
    void fillView(String name, String description, String thumbnail);
}
