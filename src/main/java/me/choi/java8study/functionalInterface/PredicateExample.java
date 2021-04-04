package me.choi.java8study.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:17 오후
 */
public class PredicateExample {
    public static void main(String[] args) {
        // TODO: 양수인지 아닌지 판단 2021/04/04 7:21 오후
        Predicate<Integer> isPositice = (value) -> value > 0;

//        isPositice(3);
        boolean result1 = isPositice.test(3);
        boolean result2 = isPositice.test(-1);

        System.out.println(result1);
        System.out.println(result2);

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (isPositice.test(number)) {
                positiveNumbers.add(number);
            }
        }
        positiveNumbers.forEach(n -> {
            System.out.println("positiveNumbers : " + n);
        });

        List<Integer> negativeNumbers = new ArrayList<>();
        Predicate<Integer> isNegative = (n) -> n < 0;
        numbers.forEach(n -> {
            if (isNegative.test(n)) {
                negativeNumbers.add(n);
            }
        });
        negativeNumbers.forEach(n -> {
            System.out.println("negativeNumbers : " + n);
        });

        filter(numbers, i -> i < -3).forEach(i -> {
            System.out.println("lessThenMinusThree : " + i);
        });

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if (filter.test(input)) {
                result.add(input);
            }
        }

        return result;
    }


}
