package top.wuhaojie.zhd.data;

import top.wuhaojie.lib.http.RetrofitHttpHelper;
import top.wuhaojie.zhd.data.api.APIService;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class HttpUtils {

    private RetrofitHttpHelper<APIService> mRetrofitHttpHelper = new RetrofitHttpHelper<>(APIService.BASE_URL, APIService.class);

    public void getStartImage() {
        mRetrofitHttpHelper.getService().getStartImage();
    }

}
