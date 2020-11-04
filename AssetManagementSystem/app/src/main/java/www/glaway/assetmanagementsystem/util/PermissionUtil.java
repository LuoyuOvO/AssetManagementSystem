package www.glaway.assetmanagementsystem.util;

import android.Manifest;
import android.os.Build;


import com.blankj.utilcode.util.PermissionUtils;

import java.util.List;



public class PermissionUtil {

    //二维码扫描需要权限
    public static final String[] PERMISSIONS_SCANQRCODE = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    //读写权限
    public static final String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    //网络权限
    public static final String[] PERMISSIONS_NETWORK = {
            Manifest.permission.INTERNET
    };


    //6.0版本或以上需请求权限，判定安卓版本
    public static boolean isGetPermissions(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            return true;
        }
        return false;
    }

    //申请权限
    public static void applyPermissions(String[] permissions, PermissionCallBack permissionCallBack) {
        //判断是否有权限
        boolean granted = PermissionUtils.isGranted(permissions);
        if (!granted) {
            PermissionUtils.permission(permissions).rationale((activity, shouldRequest) -> {
                ToastUtil.showSuccess("获取权限成功");
                permissionCallBack.Callback(true);
            }).callback(new PermissionUtils.FullCallback() {
                @Override
                public void onGranted(List<String> permissionsGranted) {
                    ToastUtil.showSuccess("获取权限成功");
                    permissionCallBack.Callback(true);
                }

                @Override
                public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
                    ToastUtil.showError("获取权限失败");
                    permissionCallBack.Callback(false);
                }
            }).theme(activity2 -> {
            }).request();
        } else {
            permissionCallBack.Callback(true);
        }
    }



    /**
     * 回调接口
     */
    public interface PermissionCallBack {
        void Callback(boolean call);
    }


}
