package com.lpc.test.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;

import com.lpc.test.R;
import com.lpc.test.activity.MainActivity;
import com.lpc.test.activity.SettingActivity;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Intent i = new Intent(this, SettingActivity.class);
                startActivity(i);
                break;
            case R.id.action_back:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
