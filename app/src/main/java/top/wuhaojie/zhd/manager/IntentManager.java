package top.wuhaojie.zhd.manager;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import java.util.ArrayList;

import top.wuhaojie.zhd.comment.CommentActivity;
import top.wuhaojie.zhd.constant.Constants;
import top.wuhaojie.zhd.detail.DetailActivity;
import top.wuhaojie.zhd.home.HomeActivity;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 19:08
 * Version: 1.0
 */

public class IntentManager {


    private IntentManager() {
    }


    public static Intent toCommentActivity(Context context, String id, String commentNumber) {
        if (context == null || TextUtils.isEmpty(id)) throw new IllegalArgumentException();
        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra(Constants.INTENT_EXTRA_STORY_ID, id);
        intent.putExtra(Constants.INTENT_EXTRA_COMMENT_NUMBER, commentNumber);
        return intent;
    }


    public static Intent toDetailActivity(Context context, ArrayList<String> ids, String currId) {
        if (ids == null || TextUtils.isEmpty(currId)) {
            throw new IllegalArgumentException("ids can not be null");
        }
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constants.INTENT_EXTRA_STORY_IDS, ids);
        intent.putExtra(Constants.INTENT_EXTRA_STORY_CURRENT_ID, currId);
        return intent;
    }


    public static Intent toMainActivity(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

}
