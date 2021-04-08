package me.choi.java8study.functionalInterface;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:33 오후
 */
public class PerformaneceExample {
    public static void main(String[] args) {
        PerformaneceExample example = new PerformaneceExample();

        long start = System.currentTimeMillis();
        example.method1();
        example.method1();
        example.method1();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        example.method2();
        example.method2();
        example.method2();
        System.out.println(System.currentTimeMillis() - start);
    }

    public void method1() {
        timeConsumingTask();
    }

    public Runnable method2() {
        return () -> timeConsumingTask();
    }

    public void timeConsumingTask() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}
