package top.wuhaojie.zhd.data.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/23 22:13
 * Version: 1.0
 */

public interface ExtraService {
    @GET
    Observable<ResponseBody> downloadFile(@Url String url);
}
