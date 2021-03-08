package me.choi.java8study.parallelstream;

import java.util.stream.Stream;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:10 오후
 */
public class ParallelStreams {

    // TODO: Stream을 이용한 병렬처리 2021/03/08 10:15 오후
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(Long::sum).get();
    }

    // TODO: 기본 for문을 이용한 합계 2021/03/08 10:17 오후
    public static long iterativeSum(long n) {
        long result = 0;

        for (int i = 0; i <= n; i++) {
            result += i;
        }

        return result;
    }

    // TODO: Parallel을 이용한 합계 2021/03/08 10:17 오후
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(Long::sum).get();
    }
}
