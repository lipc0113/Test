package com.lpc.test.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lpc.test.R;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:18 2019-07-29
 * @ Description：
 */
public class UriActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        Uri data = intent.getData();
        String scheme = data.getScheme();
        String host = data.getHost();
        String path = data.getPath();
        String query = data.getQuery();

        tv = findViewById(R.id.tv);
        tv.setText("scheme = " + scheme + ";host = " + host + ";path = " + path + ";query = " + query);
    }
}
