package com.lpc.test.activity;

import android.content.Intent;
import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.bean.Child;
import com.lpc.test.utils.ToastUtils;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class JavaTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("用注释代替枚举", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTestActivity.this, AnnotationActivity.class);
                JavaTestActivity.this.startActivity(i);
            }
        });

        /**
         * 1.父类构造器执行的时候，子类成员变量还没有初始化
         * 2.父类构造器里，执行子类的方法时，假如new子类的成员变量，而子类成员变量又有初
         *  始化，子类的成员变量初始化会覆盖前者
         */
        addBeanToMList("父类构造器调用的抽象方法对子类的成员变量的影响", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Child child = new Child();
                ToastUtils.showShortToast(child.getStudents().get(0));
            }
        });
    }
}
