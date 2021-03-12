package me.choi.java8study.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:48 오후
 */
public class StreamExample02 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // TODO: 기존의 iterative code 2021/03/12 5:49 오후
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        // TODO: reduce 사용 2021/03/12 5:50 오후
        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        Integer reduceProduct = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduceProduct);

        // TODO: 초기값이 없는 reducd 사용 2021/03/12 5:54 오후
        Optional<Integer> notInitReduceSum = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(notInitReduceSum);

    }
}
