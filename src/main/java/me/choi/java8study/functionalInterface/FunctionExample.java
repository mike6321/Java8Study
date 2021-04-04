package me.choi.java8study.functionalInterface;

import java.util.function.Function;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:50 오후
 */
public class FunctionExample {
    public static void main(String[] args) {

        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };
        final Integer number1 = toInt.apply("100");
        System.out.println(number1);

        Function<String, Integer> toIntLamda = value -> Integer.parseInt(value);
        final Integer number2 = toIntLamda.apply("100");
        System.out.println(number2);

        Function<Integer, Integer> identity = Function.identity();
        Integer number3 = identity.apply(100);
        System.out.println(number3);
    }
}
