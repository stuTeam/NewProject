package yytc.ssic.com.yytc.common;


import retrofit2.http.GET;
import rx.Observable;
import yytc.ssic.com.yytc.module.login.UserBean;

/**
 * author：${JHuiQ} on 2018/4/9 11:47
 */
public interface Request_Interface {

    @GET("openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=car")
    Observable<UserBean> getCall();
}
