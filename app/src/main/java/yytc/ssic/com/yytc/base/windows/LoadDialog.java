package yytc.ssic.com.yytc.base.windows;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.airbnb.lottie.LottieAnimationView;

import yytc.ssic.com.yytc.R;


public class LoadDialog extends Dialog {
    private static Context mContext;
    private static LoadDialog loadDialog;
    private LottieAnimationView mLottieAnimationView;

    public LoadDialog(@NonNull Context context) {
        this(context, R.style.Loadingdialog);
        mContext = context;
    }

    public LoadDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.loading_dialog);
        mLottieAnimationView = (LottieAnimationView) findViewById(R.id.lav);
    }

    private void initAnimation(String str) {
        mLottieAnimationView.setAnimation(str);
        mLottieAnimationView.loop(true);
        mLottieAnimationView.playAnimation();
    }

    private void clearAnimation() {
        mLottieAnimationView = null;
    }

    public static void showLoading(Context context) {
        if (null == loadDialog || (null != mContext && !mContext.getClass().equals(context.getClass()))) {
            loadDialog = new LoadDialog(context);
        }
        if (!loadDialog.isShowing()) {
            loadDialog.initAnimation("boxing.json");
            loadDialog.show();
        }
    }

    public static void dismissLoading() {
        if (null != loadDialog) {
            loadDialog.dismiss();
        }
    }

    public static void destoryLoading() {
        if (null != loadDialog) {
            loadDialog.clearAnimation();
             loadDialog.dismiss();
        }
        mContext = null;
        loadDialog = null;
    }
}
