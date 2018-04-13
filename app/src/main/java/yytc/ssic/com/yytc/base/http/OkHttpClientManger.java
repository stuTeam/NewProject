package yytc.ssic.com.yytc.base.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * author：${JHuiQ} on 2018/4/9 13:24
 */
public class OkHttpClientManger {
    private static final String TAG = "OkHttpClientManger";

    public static OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(OkHttpClientManger.getHeaderInterceptor())
                .retryOnConnectionFailure(true)//失败重连
                .connectTimeout(20, TimeUnit.SECONDS)//20s timeout
                .build();

        return okHttpClient;
    }

    private static Interceptor getHeaderInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String method = request.method();
                switch (method) {
                    case "GET":
                        break;
                    case "POST":
                        break;
                    default:
                        break;
                }
                return chain.proceed(chain.request());
            }
        };
        return interceptor;
    }
}
