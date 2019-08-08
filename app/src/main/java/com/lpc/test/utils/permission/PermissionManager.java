package com.lpc.test.utils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpc on 2016/11/10 0010.
 */

public class PermissionManager {

    public static final int SDK_PERMISSION_REQUEST = 127;

    /*
     * 检查有没有权限
     * */
    public static boolean checkPermission(Context context, String permission) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (PermissionChecker.checkSelfPermission(context, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }

    }

    /**
     * 请求权限，但不做其它操作
     *
     * @param permission
     */
    public static void requestPermission(Fragment fragment, String permission) {
        List<String> lists = new ArrayList<>();
        lists.add(permission);
        PermissionManager.usePermission(fragment, lists
                , null);
    }

    public static void requestPermission(Activity activity, String permission) {
        List<String> lists = new ArrayList<>();
        lists.add(permission);
        PermissionManager.usePermission(activity, lists
                , null);
    }

    /**
     * 请求权限，但不做其它操作
     *
     * @param permissions
     */
    public static void requestPermission(Fragment fragment, List<String> permissions) {
        PermissionManager.usePermission(fragment, permissions
                , null);
    }

    public static void requestPermission(Activity activity, List<String> permissions) {
        PermissionManager.usePermission(activity, permissions
                , null);
    }

    /**
     * @param permission
     * @param permissionCallback
     */
    public static void usePermission(Fragment fragment, String permission
            , PermissionCallback permissionCallback) {

        List<String> lists = new ArrayList<>();
        lists.add(permission);
        usePermission(fragment, lists, permissionCallback);
    }

    public static void usePermission(Activity activity, String permission
            , PermissionCallback permissionCallback) {

        List<String> lists = new ArrayList<>();
        lists.add(permission);
        usePermission(activity, lists, permissionCallback);
    }

    /**
     * @param permissions
     * @param permissionCallback
     */
    public static void usePermission(Fragment fragment, List<String> permissions
            , PermissionCallback permissionCallback) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            List<String> permissionsForMe = new ArrayList<String>();

            for (int i = 0; i < permissions.size(); i++) {
                if (PermissionChecker.checkSelfPermission(fragment.getContext(), permissions.get(i))
                        != PackageManager.PERMISSION_GRANTED) {
                    permissionsForMe.add(permissions.get(i));
                } else {
                    if (permissionCallback != null) {
                        permissionCallback.permissionSuccess(permissions.get(i));
                    }
                }
            }

            if (permissionsForMe.size() > 0) {
                fragment.requestPermissions(permissionsForMe.toArray(new String[permissionsForMe.size()])
                        , SDK_PERMISSION_REQUEST);
            }
        } else {
            for (String permission : permissions) {
                if (permissionCallback == null) {
                    break;
                }
                permissionCallback.permissionSuccess(permission);
            }
        }

    }

    public static void usePermission(Activity activity, List<String> permissions
            , PermissionCallback permissionCallback) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            List<String> permissionsForMe = new ArrayList<String>();

            for (int i = 0; i < permissions.size(); i++) {
                if (PermissionChecker.checkSelfPermission(activity, permissions.get(i))
                        != PackageManager.PERMISSION_GRANTED) {
                    permissionsForMe.add(permissions.get(i));
                } else {
                    if (permissionCallback != null) {
                        permissionCallback.permissionSuccess(permissions.get(i));
                    }
                }
            }

            if (permissionsForMe.size() > 0) {
                ActivityCompat.requestPermissions(activity
                        , permissionsForMe.toArray(new String[permissionsForMe.size()]), SDK_PERMISSION_REQUEST);
            }
        } else {
            for (String permission : permissions) {
                if (permissionCallback == null) {
                    break;
                }
                permissionCallback.permissionSuccess(permission);
            }
        }

    }

    /**
     * 在activity或者fragment的回调方法onRequestPermissionsResult后加此方法
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     * @param permissionCallback
     */
    public static void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults, PermissionCallback permissionCallback) {
        if (requestCode == SDK_PERMISSION_REQUEST) {

            for (int i = 0; i < permissions.length; i++) {
                if (PackageManager.PERMISSION_GRANTED == grantResults[i]) {
                    if (permissionCallback != null) {
                        permissionCallback.permissionSuccess(permissions[i]);
                    }

                } else {

                    if (permissionCallback != null) {
                        permissionCallback.permissionFail(permissions[i]);
                    }

                }
            }
        }

    }

    /**
     * 这个方法可以加一个拒绝权限后的提示， 目前 还没有用
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     * @param permissionCallback
     */
    public static void onRequestPermissionsResult(Fragment fragment, int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults, PermissionCallback permissionCallback, String[] rationales) {

        if (requestCode == SDK_PERMISSION_REQUEST) {

            for (int i = 0; i < permissions.length; i++) {
                if (PackageManager.PERMISSION_GRANTED == grantResults[i]) {
                    if (permissionCallback != null) {
                        permissionCallback.permissionSuccess(permissions[i]);
                    }

                } else {

                    if (fragment.shouldShowRequestPermissionRationale(permissions[i])) {
                        if (rationales != null && !TextUtils.isEmpty(rationales[i])) {
                            alertDialogForPermission(fragment, permissions[i], permissionCallback, rationales[i]);
                        }
                    }

                    if (permissionCallback != null) {
                        permissionCallback.permissionFail(permissions[i]);
                    }

                }
            }
        }

    }

    public static void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults, PermissionCallback permissionCallback, String[] rationales) {

        if (requestCode == SDK_PERMISSION_REQUEST) {

            for (int i = 0; i < permissions.length; i++) {
                if (PackageManager.PERMISSION_GRANTED == grantResults[i]) {
                    if (permissionCallback != null) {
                        permissionCallback.permissionSuccess(permissions[i]);
                    }

                } else {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissions[i])) {
                        if (rationales != null && !TextUtils.isEmpty(rationales[i])) {
                            alertDialogForPermission(activity, permissions[i], permissionCallback, rationales[i]);
                        }
                    }

                    if (permissionCallback != null) {
                        permissionCallback.permissionFail(permissions[i]);
                    }

                }
            }
        }

    }

    private static void alertDialogForPermission(final Fragment fragment, final String permission
            , final PermissionCallback permissionCallback, final String content) {
        new AlertDialog.Builder(fragment.getActivity())
                .setMessage(content)
                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        usePermission(fragment, permission, permissionCallback);
                    }
                })
                .setNegativeButton("禁止", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private static void alertDialogForPermission(final Activity activity, final String permission
            , final PermissionCallback permissionCallback, final String content) {
        new AlertDialog.Builder(activity)
                .setMessage(content)
                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        usePermission(activity, permission, permissionCallback);
                    }
                })
                .setNegativeButton("禁止", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

}
