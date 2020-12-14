package me.choi.java8study;

import java.util.function.BiFunction;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:36 오전
 */
public class Foo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (number1, number2) -> number1 * number2;
        System.out.println(biFunction.apply(20, 40));;
    }
}
