package yytc.ssic.com.yytc.module.login;

import rx.Observable;
import yytc.ssic.com.yytc.base.callback.BaseCallback;
import yytc.ssic.com.yytc.base.http.ExecuteHttpManger;
import yytc.ssic.com.yytc.base.mvp.BasePresenterImpl;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";

    @Override
    public void login(Observable<UserBean> observable) {
        ExecuteHttpManger.executeHttp(observable, new BaseCallback<UserBean>(mView.getContext()) {

            @Override
            public void onError(String e) {
                mView.loginFailure(e);
            }

            @Override
            public void onNext(UserBean userBean) {
                mView.loginSuccess(userBean);
            }
        });
    }
}
