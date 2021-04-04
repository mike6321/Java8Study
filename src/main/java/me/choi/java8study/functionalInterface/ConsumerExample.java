package me.choi.java8study.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:09 오후
 */
public class ConsumerExample {
    public static void main(String[] args) {
        final Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        print.accept("Hello");

        Consumer<String> printLamda = (value) -> System.out.println(value);
        printLamda.accept("Hello");

        Function<String, Void> printLamdaWithFunction = (value) -> System.out.println(value);
    }
}
