package me.choi.java8study.closure;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:25 오후
 */
public class ClosureSummary {

    int number = 10;

    public static void main(String[] args) {
        int number = 20;

        Runnable runnable1 = new Runnable() {

            int number = 30;
            // 안된다.
            //number = 20;
            @Override
            public void run() {
                int number = 40;
            }
        };

        Runnable runnable2 = () -> {
            // 안된다.
            //number = 30;

        };
    }

    private void testMethod1() {
        int number = 10;

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                //안된다.
                //number = 11;
            }
        };

        Runnable runnable2 = () -> {
            //안된다.
            //number = 11;
        };
    }

    int classNumber = 11;
    private void testMethod2() {
//        int number = 10;
        final AtomicInteger number = new AtomicInteger();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                number.getAndIncrement();
            }
        };
    }
}

