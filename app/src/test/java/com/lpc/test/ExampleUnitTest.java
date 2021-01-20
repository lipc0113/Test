package com.lpc.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect9() {
        String str = "00123";
        System.out.println("str = " + Integer.valueOf(str));
    }

    @Test
    public void addition_isCorrect8() {

        int i = -1;
        int j = -2147483648;
        int m = -2147483647;

        System.out.println("l = " + -i);
        System.out.println("l = " + Math.abs(i));
        System.out.println("l = " + Math.abs(j));
        System.out.println("l = " + Math.abs(m));
        System.out.println("l = " + -Integer.MIN_VALUE);
        System.out.println("l = " + -(Integer.MIN_VALUE / 10));
        System.out.println("l = " + -Integer.MIN_VALUE / 10);
    }

    @Test
    public void addition_isCorrect7() {

        String s = "{\"id\":123}";
        Gson gson = new Gson();
        People people = gson.fromJson(s, People.class);
        System.out.println("id = " + people.getId());

        String s2 = "{\"id\":123,\"name\":\"lpc\",\"age\":12}";
        People people2 = gson.fromJson(s2, People.class);
        System.out.println("id2 = " + people2.getId());

    }

    @Test
    public void addition_isCorrect6() {

        new Thread() {
            @Override
            public void run() {
                super.run();
                println(1111);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                super.run();
                println(2222);
                println(4444);
            }
        }.start();
        println(333);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_isCorrect() {

        String s = "小度小度";
        String ss = s.replace("小度", "小云");
        System.out.println("ss = " + ss);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_isCorrect2() {

        String weather = "多云";
        if (weather.contains("雨")) {
            System.out.println("ss = 雨");
        } else {
            System.out.println("ss = 没雨");
        }
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_isCorrect3() {

        String s = new String("123");
    }

    @Test
    public void addition_isCorrect4() {

        int i = 10;
        int j = 11;
        System.out.println("i|=j = " + (i ^ j)); // 异或
        System.out.println("i|=j = " + (i |= j)); // 位或
//        assertEquals(4, i|=j);
    }

    @Test
    public void addition_isCorrect5() {

        println(-1);

        for (int i = 0; i < 10; i++) {
            println(i);
        }

        println(11);
    }

    private void println(int i) {
        System.out.println("i = " + i);
    }
}