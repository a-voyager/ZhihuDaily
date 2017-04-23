package top.wuhaojie.zhd.data.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import top.wuhaojie.zhd.entities.BeforeMessageResponse;
import top.wuhaojie.zhd.entities.DetailMessageResponse;
import top.wuhaojie.zhd.entities.LatestMessageResponse;
import top.wuhaojie.zhd.entities.LongCommentResponse;
import top.wuhaojie.zhd.entities.ShortCommentResponse;
import top.wuhaojie.zhd.entities.StartImageResponse;
import top.wuhaojie.zhd.entities.StoryExtraResponse;

/**
 * Created by wuhaojie on 17-2-9.
 */

public interface APIService {
    String BASE_URL = "http://news-at.zhihu.com/api/";

    @GET("7/prefetch-launch-images/{width}*{height}")
    Observable<StartImageResponse> getStartImage(@Path("width") int width, @Path("height") int height);

    @GET("4/news/latest")
    Observable<LatestMessageResponse> getLatestMessages();

    @GET("4/news/{id}")
    Observable<DetailMessageResponse> getDetailMessage(@Path("id") String id);

    @GET("4/story-extra/{id}")
    Observable<StoryExtraResponse> getStoryExtra(@Path("id") String id);

    @GET("4/news/before/{date}")
    Observable<BeforeMessageResponse> getBeforeMessage(@Path("date") String date);

    @GET("4/story/{id}/long-comments")
    Observable<LongCommentResponse> getLongComment(@Path("id") String id);

    @GET("4/story/{id}/short-comments")
    Observable<ShortCommentResponse> getShortComment(@Path("id") String id);

}
