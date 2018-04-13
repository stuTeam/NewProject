package yytc.ssic.com.yytc.module.login;

import rx.Observable;
import yytc.ssic.com.yytc.base.mvp.BasePresenter;
import yytc.ssic.com.yytc.base.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        void loginSuccess(UserBean userBean);
        void loginFailure(String failureStr);
    }

    interface  Presenter extends BasePresenter<View> {

        void login(Observable<UserBean> observable);
        
    }
}
