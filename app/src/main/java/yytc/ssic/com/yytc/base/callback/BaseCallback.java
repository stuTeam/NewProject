package yytc.ssic.com.yytc.base.callback;

import android.content.Context;
import android.util.Log;

import yytc.ssic.com.yytc.base.windows.LoadDialog;

/**
 * author：${JHuiQ} on 2018/4/9 13:59
 */
public abstract class BaseCallback<T> {

    private Context mContext;
    private static final String TAG = "BaseCallback";

    public BaseCallback() {
    }

    public BaseCallback(Context context) {
        this.mContext = context;
    }

    public void onStart() {
        Log.d(TAG, "---ssssssstart-------发----起----请----求----网-----络--------------------------------------------------------");
        if (null != mContext) {
            LoadDialog.showLoading(mContext);
        }
    }

    public void onCompleted() {
        Log.d(TAG, "------eeeeeeend-------网-----络-----请-----求-----结-----束--------------------------------------------------------");
        LoadDialog.dismissLoading();
    }

    public abstract void onError(String e);

    public abstract void onNext(T t);
}
