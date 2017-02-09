package top.wuhaojie.zhd.data.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by wuhaojie on 17-2-9.
 */

public interface APIService {
    String BASE_URL = "";

    @GET("/")
    Observable<ResponseBody> getStartImage();

}
