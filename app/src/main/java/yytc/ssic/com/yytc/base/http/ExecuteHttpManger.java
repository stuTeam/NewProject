package yytc.ssic.com.yytc.base.http;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yytc.ssic.com.yytc.base.callback.BaseCallback;

/**
 * author：${JHuiQ} on 2018/4/9 13:57
 */
public class ExecuteHttpManger {

    private static final String TAG = "ExecuteHttpManger";

    public static <T> void executeHttp(Observable<T> observable, final BaseCallback<T> callback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        callback.onStart();
                    }

                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                        //调用了onError就不会调用onCompleted
                        callback.onCompleted();
                        if (e.toString().indexOf("TimeoutException") != -1) {
                            callback.onError("  网络超时,请重试!  ");
                            return;
                        }
                        if (e.toString().indexOf("EOFException") != -1) {
                            callback.onError("  数据解析失败!  ");
                            return;
                        }
                        if (e.toString().indexOf("ConnectException") != -1) {
                            callback.onError("  网络错误,请检查网络是否连接可用!  ");
                            return;
                        }
                        callback.onError("  获取数据失败!请重试  ");
                    }

                    @Override
                    public void onNext(T t) {
                        callback.onNext(t);
                    }
                });

    }

}
