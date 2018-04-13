package yytc.ssic.com.yytc.base.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yytc.ssic.com.yytc.common.AppConfig;

/**
 * author：${JHuiQ} on 2018/4/9 13:14
 */
public class RetroftServiceManager {


    public static <T> T getService(Class<T> cls) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(AppConfig.baseUrl) //设置网络请求的Url地址
                .client(OkHttpClientManger.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return build.create(cls);
    }
}
