package www.glaway.assetmanagementsystem.util;

import android.widget.Toast;

import com.blankj.utilcode.util.Utils;

import es.dmoral.toasty.Toasty;

/**
 * Toast工具类
 */
public class ToastUtil {


    /**
     * 成功提示
     * @param txt
     */
    public static void showSuccess(String txt) {
        Toasty.success(Utils.getApp(), txt, Toast.LENGTH_SHORT, true).show();
    }

    /**
     * 错误提示
     * @param txt
     */
    public static void showError(String txt) {
        Toasty.error(Utils.getApp(), txt, Toast.LENGTH_SHORT, true).show();
    }
    /**
     * 长错误提示
     * @param txt
     */
    public static void showErrorLong(String txt) {
        Toasty.error(Utils.getApp(), txt, Toast.LENGTH_LONG, true).show();
    }
    /**
     * 信息提示
     * @param txt
     */
    public static void showInfo(String txt) {
        Toasty.info(Utils.getApp(), txt, Toast.LENGTH_SHORT, true).show();
    }

    /**
     * 警告提示
     * @param txt
     */
    public static void showWarning(String txt) {
        Toasty.warning(Utils.getApp(), txt, Toast.LENGTH_SHORT, true).show();
    }
}
