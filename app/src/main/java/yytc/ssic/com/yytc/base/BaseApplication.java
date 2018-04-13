package yytc.ssic.com.yytc.base;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //注册友盟统计
        registeredUMenuount();
    }

    private void registeredUMenuount() {
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null);
    }
}
