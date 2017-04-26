package top.wuhaojie.zhd.home.theme.editors;

import java.util.ArrayList;

import top.wuhaojie.zhd.home.theme.adapter.EditorsAdapter;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/26 13:12
 * Version: 1.0
 */

public interface EditorsView {
    void setEditorsList(ArrayList<EditorsAdapter.Item> items);
}
