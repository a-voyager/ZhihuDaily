package top.wuhaojie.zhd.comment;

import java.util.ArrayList;

import top.wuhaojie.zhd.base.interfaces.BaseView;
import top.wuhaojie.zhd.comment.adapter.CommentListAdapter;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 19:01
 * Version: 1.0
 */

public interface CommentView extends BaseView {
    void updateToolbar(String commentNumber);

    void back();

    void showWaitDialog();

    void dismissWaitDialog();

    void updateList(ArrayList<CommentListAdapter.Item<?>> items);

    void appendList(ArrayList<CommentListAdapter.Item<?>> items);

    void removeList(int lastSize);

    void showContextDialog(String[] items, int type, String id);
}
