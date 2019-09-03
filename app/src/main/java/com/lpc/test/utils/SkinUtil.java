package com.lpc.test.utils;

import android.content.Context;

import com.lpc.test.Constants;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import cn.feng.skin.manager.listener.ILoaderListener;
import cn.feng.skin.manager.loader.SkinManager;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 16:21 2019-09-02
 * @ Description：
 */
public class SkinUtil {

    /**
     * asset目录释放缓存区大小
     */
    private static final int BUFFER_SIZE = 2048;

    private static WeakReference<SkinILoaderListener> skinILoaderListener;

    public void setSkinILoaderListener(SkinILoaderListener skinILoaderListener) {
        this.skinILoaderListener = new WeakReference<>(skinILoaderListener);
    }

    public static void init(Context context) {

        if (installSkinIfNeeded()) {
            SkinManager.getInstance().init(context);
            SkinManager.getInstance().load();
        }
    }

    public static void restoreDefaultTheme() {
        SkinManager.getInstance().restoreDefaultTheme();
    }

    public static void setDarkSkin() {
        String SKIN_DIR = Constants.SKIN_DARK_FILE_PATH;
        File skin = new File(SKIN_DIR);
        SkinManager.getInstance().load(skin.getAbsolutePath(),
                new ILoaderListener() {
                    @Override
                    public void onStart() {
                        if (skinILoaderListener != null && skinILoaderListener.get() != null) {
                            skinILoaderListener.get().onSkinStart();
                        }
                    }

                    @Override
                    public void onSuccess() {
                        if (skinILoaderListener != null && skinILoaderListener.get() != null) {
                            skinILoaderListener.get().onSkinSuccess();
                        }
                    }

                    @Override
                    public void onFailed() {
                        if (skinILoaderListener != null && skinILoaderListener.get() != null) {
                            skinILoaderListener.get().onSkinFailed();
                        }
                    }
                });
    }

    private static boolean installSkinIfNeeded() {

        File file = new File(Constants.SKIN_DARK_FILE_PATH);
        if (file.exists()) {
            return true;
        }

        FileUtils.createOrExistsFile(Constants.SKIN_DARK_FILE_PATH);

        InputStream inputStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            inputStream = UIUtil.getContext().getAssets().open("skin/dark_color.skin");
            // 若文件长度检查通过则认为皮肤包已安装，直接返回
            bis = new BufferedInputStream(inputStream);
            bos = new BufferedOutputStream(new FileOutputStream(Constants.SKIN_DARK_FILE_PATH));
            int len;
            byte[] bs = new byte[BUFFER_SIZE];
            while ((len = bis.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (bos != null) {
                    bos.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public interface SkinILoaderListener {
        void onSkinStart();

        void onSkinSuccess();

        void onSkinFailed();
    }
}
