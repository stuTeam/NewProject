package yytc.ssic.com.yytc.module.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import yytc.ssic.com.yytc.R;
import yytc.ssic.com.yytc.base.mvp.MVPBaseActivity;
import yytc.ssic.com.yytc.base.windows.ToastCommon;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    @InjectView(R.id.account_et)
    EditText mAccountEt;
    @InjectView(R.id.password_et)
    EditText mPasswordEt;

    private static final String TAG = "LoginActivity";
    @InjectView(R.id.rb1)
    RadioButton mRb1;
    @InjectView(R.id.rb2)
    RadioButton mRb2;
    @InjectView(R.id.rg)
    RadioGroup mRg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        openSwitchIp();
    }

    private void openSwitchIp() {
        mRg.setVisibility(View.VISIBLE);
        mRg.check(R.id.rb1);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        break;
                    case R.id.rb2:
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @OnClick(R.id.login_bt)
    public void onViewClicked() {
        mPresenter.login(bindObs(mService.getCall()));
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        Log.d(TAG, "loginSuccess: ");
        ToastCommon.toastSuccess(this,userBean.toString());
    }

    @Override
    public void loginFailure(String failureStr) {
        ToastCommon.toast(this, failureStr);
    }
}
