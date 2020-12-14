package me.choi.java8study;

import java.util.function.Consumer;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:36 오전
 */
public class Foo {
    public static void main(String[] args) {
        Consumer<Integer> print = (i) -> System.out.println(i);
        print.accept(10);

        Consumer<Integer> print2 = System.out::println;
        print.accept(10);
    }
}
