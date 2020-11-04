package www.glaway.assetmanagementsystem.dialog;

import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;

import www.glaway.assetmanagementsystem.R;

public abstract class BaseDialog extends DialogFragment {


    private Window window;
    protected DialogCallback callback;

    /**
     * 初始化界面
     */
    public abstract void initview();

    /**
     * 输入校验
     */
    public abstract boolean checkInput();

    /**
     * 弹出样式
     */
    @Override
    public void onStart() {
        super.onStart();
        // 下面这些设置必须在此方法(onStart())中才有效

        window = getDialog().getWindow();
        // 如果不设置这句代码, 那么弹框就会与四边都有一定的距离
        window.setBackgroundDrawableResource(android.R.color.transparent);
        // 设置动画
        window.setWindowAnimations(R.style.topDialog);

        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.RIGHT;
        // 如果不设置宽度,那么即使你在布局中设置宽度为 match_parent 也不会起作用
        params.width = (int) (getResources().getDisplayMetrics().widthPixels * (0.8f));
        params.height = (int) (getResources().getDisplayMetrics().heightPixels * (0.85f));
        window.setAttributes(params);
    }


    /**
     * 设置回调
     *
     * @param callback
     */
    public void setCallback(DialogCallback callback) {
        this.callback = callback;
    }

    /**
     * 内部接口
     */
    public interface DialogCallback {
        void call(Object call);
    }
}
