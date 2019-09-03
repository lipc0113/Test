package com.lpc.test;

import android.os.Environment;

import java.io.File;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 16:51 2019-09-02
 * @ Description：
 */
public class Constants {

    /**
     * 基本sd卡存储路径
     */
    public static final String BASE_ENVIRONMENT_FILE_PATH = Environment.getExternalStorageDirectory()
            + File.separator + "Test";

    /**
     * 皮肤包存储路径
     */
    public static String SKIN_FILE_PATH = BASE_ENVIRONMENT_FILE_PATH + File.separator + "skin";

    /**
     * 暗色皮肤包存储路径
     */
    public static String SKIN_DARK_FILE_PATH = SKIN_FILE_PATH + File.separator + "dark_color.skin";
}
