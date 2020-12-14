package me.choi.java8study;

import java.util.function.Predicate;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:36 오전
 */
public class Foo {
    public static void main(String[] args) {
        Predicate<String> startsWithJunwoo = (str) -> str.charAt(0) == 'j';
        System.out.println(startsWithJunwoo.test("junwoo"));
        System.out.println(startsWithJunwoo.test("wunwoo"));

        Predicate<Integer> isEven = (i) -> i % 2 == 0;
    }
}
