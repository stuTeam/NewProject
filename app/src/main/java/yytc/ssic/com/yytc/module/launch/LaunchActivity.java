package yytc.ssic.com.yytc.module.launch;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import yytc.ssic.com.yytc.R;
import yytc.ssic.com.yytc.base.mvp.MVPBaseActivity;
import yytc.ssic.com.yytc.module.login.LoginActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LaunchActivity extends MVPBaseActivity<LaunchContract.View, LaunchPresenter> implements LaunchContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.login_bt)
    public void onViewClicked() {
        Intent intent = new Intent(LaunchActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
