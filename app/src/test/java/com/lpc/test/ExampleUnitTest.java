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

        String s = "1.01";
        System.out.println("s = " + Float.valueOf(s).intValue());
        assertEquals(4, 2 + 2);
    }
}