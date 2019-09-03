package com.lpc.test.activity;

import android.view.View;
import android.widget.TextView;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;
import com.lpc.test.utils.SkinUtil;
import com.lpc.test.utils.ToastUtils;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 19:25 2019-08-26
 * @ Description：
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener
    , SkinUtil.SkinILoaderListener {

    private TextView tvSkinLight;
    private TextView tvSkinDark;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {

        tvSkinLight = findViewById(R.id.tv_skin_light);
        tvSkinDark = findViewById(R.id.tv_skin_dark);
    }

    @Override
    protected void initData() {

        tvSkinLight.setOnClickListener(this);
        tvSkinDark.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skin_light:
                SkinUtil.restoreDefaultTheme();
                break;
            case R.id.tv_skin_dark:
                SkinUtil.setDarkSkin();
                break;
        }
    }

    @Override
    public void onSkinStart() {

    }

    @Override
    public void onSkinSuccess() {
        ToastUtils.showShortToast("换肤成功");
    }

    @Override
    public void onSkinFailed() {
        ToastUtils.showShortToast("换肤失败");
    }
}
