package top.wuhaojie.lib.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wuhaojie on 17-2-9.
 */

public class RetrofitHttpHelper<T> {


    private T mApiService;

    public RetrofitHttpHelper(final String baseUrl, final Class<T> service) {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApiService = retrofit.create(service);
    }

    public T getService() {
        if (mApiService == null)
            throw new NullPointerException();
        return mApiService;
    }


}
