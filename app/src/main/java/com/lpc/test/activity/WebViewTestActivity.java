package com.lpc.test.activity;

import android.view.View;
import android.webkit.WebView;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 20:28 2019-08-08
 * @ Description：
 */
public class WebViewTestActivity extends BaseActivity {

    private static final String URL = "https://202.108.23.94/text2audio";

    private WebView web;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {

        web = findViewById(R.id.web);
    }

    @Override
    protected void initData() {

        web.loadUrl(URL);
    }
}
