package com.lpc.test.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lpc on 2016/10/31 0031.
 */

public class ActivityStackManager {

    private List<Activity> stack = new ArrayList<Activity>();

    private static ActivityStackManager activityStackManager = new ActivityStackManager();

    public static ActivityStackManager getInstance() {
        return activityStackManager;
    }

    /*
    * 得到栈顶的activity
    * */
    public Activity getTopActivity() {

        if (stack != null) {
            return stack.get(stack.size() - 1);
        }
        return null;
    }

    /**
     * 入栈
     *
     * @param activity
     */
    public void push(Activity activity) {

        if (activity != null) {
            stack.add(activity);
        }

    }

    /**
     * 出栈
     *
     * @param activity
     */
    public void pop(Activity activity) {

        if (activity != null) {
            stack.remove(activity);
        }
    }

    /**
     * 清空栈
     */
    public void clearAllActivity() {

        Activity activity = null;

        Iterator<Activity> iterator = stack.iterator();

        while(iterator.hasNext()){

            Activity aty = iterator.next();
            iterator.remove();
            aty.finish();
        }

        stack.clear();
    }

}
