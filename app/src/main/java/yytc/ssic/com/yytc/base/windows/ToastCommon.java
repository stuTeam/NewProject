package yytc.ssic.com.yytc.base.windows;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import yytc.ssic.com.yytc.R;


/**
 * @Author: jHuiQ
 * @Date:on 2018/04/11.
 * @E-mail:1395320136@qq.com
 */

public class ToastCommon {

    private static Toast sToast;
    private static Toast sToastSuccess;

    public static void toast(Context context, String content) {
        if (null==sToast) {
            //创建一个toast
            sToast = new Toast(context);
            sToast.setDuration(Toast.LENGTH_SHORT);          //设置toast显示时间，整数值
            sToast.setGravity(Gravity.CENTER, Gravity.CENTER, Gravity.CENTER);    //toast的显示位置，这里居中显示
            View view = View.inflate(context, R.layout.toast, null);      //加载布局文件
            TextView textView = (TextView) view.findViewById(R.id.toast_text);    // 得到textview
            textView.setText(content);     //设置文本类荣，就是你想给用户看的提示数据
            sToast.setView(view);     //設置其显示的view,
        }else {
            View sToastView = sToast.getView();
            TextView toastTv = (TextView) sToastView.findViewById(R.id.toast_text);
            toastTv.setText(content);
        }
        sToast.show();             //显示toast
    }

    public static void toastSuccess(Context context, String content) {
        if (null==sToastSuccess) {
            //创建一个toast
            sToastSuccess = new Toast(context);
            sToastSuccess.setDuration(Toast.LENGTH_SHORT);          //设置toast显示时间，整数值
            sToastSuccess.setGravity(Gravity.CENTER, Gravity.CENTER, Gravity.CENTER);    //toast的显示位置，这里居中显示
            View view = View.inflate(context, R.layout.toast, null);      //加载布局文件
            ImageView toaIv = (ImageView) view.findViewById(R.id.toast_iv);
            toaIv.setBackgroundResource(R.mipmap.toast_person_success);
            TextView textView = (TextView) view.findViewById(R.id.toast_text);    // 得到textview
            textView.setText(content);     //设置文本类荣，就是你想给用户看的提示数据
            sToastSuccess.setView(view);     //設置其显示的view,
        }else {
            View sToastSuccessView = sToastSuccess.getView();
            TextView successTv = (TextView) sToastSuccessView.findViewById(R.id.toast_text);
            successTv.setText(content);
        }
        sToastSuccess.show();             //显示toast
    }
}
