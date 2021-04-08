package me.choi.java8study.functionalInterface;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
        example.method();
        example.method();
        example.method();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        example.method(() -> example.timeConsumingTask());
        example.method(() -> example.timeConsumingTask());
        example.method(() -> example.timeConsumingTask());
        System.out.println(System.currentTimeMillis() - start);
    }

    public void method() {
        timeConsumingTask();
    }

    public void method(Runnable runnable) {

    }

    public void timeConsumingTask() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
