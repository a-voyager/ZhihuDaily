package top.wuhaojie.zhd.comment;

import top.wuhaojie.zhd.base.interfaces.BaseView;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 19:01
 * Version: 1.0
 */

public interface CommentView extends BaseView {
    void updateToolbar(String commentNumber);

    void back();
}
