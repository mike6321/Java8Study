package me.choi.java8study.stream.kevin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:11 오후
 */
public class StreamExample01 {
    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = null;
        for (final Integer number : numbers) {
            if (number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("Imperative Result : " + result);

        System.out.println("Functional Result : " +
        numbers.stream()
                .filter(num -> num > 3 && num < 9)
                .map(num -> num * 2)
                .filter(num -> num > 10)
                .findFirst()
                .get()
        );
    }
}
