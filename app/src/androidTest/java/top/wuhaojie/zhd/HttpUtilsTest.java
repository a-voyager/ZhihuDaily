package top.wuhaojie.zhd;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Subscriber;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.ShortCommentResponse;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 21:03
 * Version: 1.0
 */
@RunWith(AndroidJUnit4.class)
public class HttpUtilsTest {

    @Test
    public void getStartImage() throws Exception {

    }

    @Test
    public void getLatestMessages() throws Exception {

    }

    @Test
    public void getDetailMessage() throws Exception {

    }

    @Test
    public void getStoryExtra() throws Exception {

    }

    @Test
    public void getBeforeMessage() throws Exception {

    }

    @Test
    public void getLongComment() throws Exception {

    }

    @Test
    public void getShortComment() throws Exception {
        HttpUtils.getShortComment("9344953", new Subscriber<ShortCommentResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShortCommentResponse shortCommentResponse) {
                System.out.println(shortCommentResponse);
            }
        });
        while (true);
    }

}
