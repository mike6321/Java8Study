package me.choi.java8study;

import java.util.function.Function;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:36 오전
 */
public class Foo {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (number) -> number + 10;
        Function<Integer, Integer> multiply2 = (number) -> number * 2;
        System.out.println(plus10.apply(20));

        // * 2 연산 후 + 10
        Function<Integer, Integer> mutiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(mutiply2AndPlus10.apply(10));

        // + 연산 후 * 2
        Integer andThen = plus10.andThen(multiply2).apply(10);
        System.out.println(andThen);

    }
}
