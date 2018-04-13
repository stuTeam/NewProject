package yytc.ssic.com.yytc.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.umeng.analytics.MobclickAgent;

import java.lang.reflect.ParameterizedType;

import rx.Observable;
import yytc.ssic.com.yytc.base.http.RetroftServiceManager;
import yytc.ssic.com.yytc.base.windows.LoadDialog;
import yytc.ssic.com.yytc.common.Request_Interface;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public abstract class MVPBaseActivity<V extends BaseView, T extends BasePresenterImpl<V>> extends RxAppCompatActivity implements BaseView {
    public T mPresenter;
    public Request_Interface mService = RetroftServiceManager.getService(Request_Interface.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getInstance(this, 1);
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消掉loading
        LoadDialog.destoryLoading();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    public <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    //防止Rxjava由于订阅者内存泄漏，每个网络请求必须调用
    public <B> Observable<B> bindObs(Observable<B> observable) {
        return observable.compose(this.<B>bindToLifecycle());
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
