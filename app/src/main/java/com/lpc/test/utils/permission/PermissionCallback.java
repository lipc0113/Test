package com.lpc.test.utils.permission;

/**
 * Created by lpc on 2016/11/11 0011.
 */

public interface PermissionCallback {

    /**
     * @param permission   请求多个权限时，返回的集合中的对应权限
     */
    public void permissionSuccess(String permission);

    public void permissionFail(String permission);
}
