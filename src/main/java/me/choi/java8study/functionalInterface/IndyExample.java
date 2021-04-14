package me.choi.java8study.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:58 오후
 */
public class IndyExample {
    private int number;

    public void method() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        };
    }

    public MyFunction Functimethod() {
        MyFunction myFunction = () -> {};



        return  () -> {};
    }
}
