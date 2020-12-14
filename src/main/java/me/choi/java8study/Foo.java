package me.choi.java8study;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:36 오전
 */
public class Foo {
    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = (i) -> i + 100;
        System.out.println(unaryOperator.apply(4700));
    }
}
