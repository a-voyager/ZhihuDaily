package top.wuhaojie.zhd.data.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;
import top.wuhaojie.zhd.entities.LatestMessageResponse;

/**
 * Created by wuhaojie on 17-2-9.
 */

public interface APIService {
    String BASE_URL = "http://news-at.zhihu.com/api/4/news/";

    @GET("")
    Observable<ResponseBody> getStartImage();

    @GET("latest")
    Observable<LatestMessageResponse> getLatestMessages();

}
