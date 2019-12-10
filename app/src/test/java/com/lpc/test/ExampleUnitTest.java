package com.lpc.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

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