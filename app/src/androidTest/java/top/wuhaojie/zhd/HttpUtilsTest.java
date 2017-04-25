package top.wuhaojie.zhd;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Subscriber;
import top.wuhaojie.zhd.data.HttpUtils;
import top.wuhaojie.zhd.entities.ShortCommentResponse;
import top.wuhaojie.zhd.entities.ThemesListResponse;
import top.wuhaojie.zhd.entities.ThemesResponse;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/08 21:03
 * Version: 1.0
 */
@RunWith(AndroidJUnit4.class)
public class HttpUtilsTest {
    @Test
    public void getThemes() throws Exception {
        HttpUtils.getThemes("5", new Subscriber<ThemesResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ThemesResponse themesResponse) {
                System.out.println(themesResponse);
            }
        });
        while (true) ;
    }

    @Test
    public void getThemesList() throws Exception {
        HttpUtils.getThemesList(new Subscriber<ThemesListResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ThemesListResponse themesListResponse) {
                System.out.println(themesListResponse);
            }
        });
        while (true) ;
    }

    @Test
    public void downloadFile() throws Exception {
//        HttpUtils.downloadFile("https://pic4.zhimg.com/v2-d0837fd8e39d98b2d58d1911e4fbd913.jpg", new File(""));
        while (true) ;
    }

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
        while (true) ;
    }

}
