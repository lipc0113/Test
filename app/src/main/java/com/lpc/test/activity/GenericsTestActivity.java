package com.lpc.test.activity;

import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.bean.Generator;
import com.lpc.test.utils.LogUtil;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class GenericsTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("泛型-上下边界", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Generator<Integer> gInteger = new Generator<Integer>(123);
                Generator<Number> gNumber = new Generator<Number>(456);

//                showKeyValue1(gInteger);
                showKeyValue1(gNumber);

                showKeyValue2(gInteger);
                showKeyValue2(gNumber);

                showKeyValue3(gInteger);
                showKeyValue3(gNumber);
            }
        });

    }

    public void showKeyValue1(Generator<Number> obj) {
        LogUtil.d("泛型测试 key value is " + obj.getKey());
    }

    public void showKeyValue2(Generator<? extends Number> obj) {
        LogUtil.d("泛型测试2 key value is " + obj.getKey());
    }

    public <T extends Number> void showKeyValue3(Generator<T> obj) {
        LogUtil.d("泛型测试3 key value is " + obj.getKey());
    }
}
