package top.wuhaojie.zhd.data.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import top.wuhaojie.zhd.entities.BeforeMessageResponse;
import top.wuhaojie.zhd.entities.DetailMessageResponse;
import top.wuhaojie.zhd.entities.LatestMessageResponse;
import top.wuhaojie.zhd.entities.StoryExtraResponse;

/**
 * Created by wuhaojie on 17-2-9.
 */

public interface APIService {
    String BASE_URL = "http://news-at.zhihu.com/api/4/";

    @GET("")
    Observable<ResponseBody> getStartImage();

    @GET("news/latest")
    Observable<LatestMessageResponse> getLatestMessages();

    @GET("news/{id}")
    Observable<DetailMessageResponse> getDetailMessage(@Path("id") String id);

    @GET("story-extra/{id}")
    Observable<StoryExtraResponse> getStoryExtra(@Path("id") String id);

    @GET("news/before/{date}")
    Observable<BeforeMessageResponse> getBeforeMessage(@Path("date") String date);

}
