package com.lpc.test.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.lpc.test.utils.ActivityStackManager;

import cn.feng.skin.manager.base.BaseSkinAppCompatActivity;
import cn.feng.skin.manager.base.BaseSkinFragmentActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:56 2019-08-07
 * @ Description：
 */
public abstract class BaseActivity extends BaseSkinAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityStackManager.getInstance().push(this);

        setContentView(getContentViewResid());

        initView();
        initData();
    }

    protected abstract int getContentViewResid();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityStackManager.getInstance().pop(this);
    }
}
