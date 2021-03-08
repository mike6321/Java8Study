package me.choi.java8study.parallelstream;

import java.util.function.Function;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment : 병렬 스트림 성능 측정
 * Time : 10:03 오후
 */
public class Example02 {
    public static void main(String[] args) {
        System.out.println("Stream을 이용한 합계 = " + Example02.measureSumPerf(ParallelStreams::sequentialSum, 10_000_000L) + "msecs");
        System.out.println("기본 for문을 이용한 합계 = " + Example02.measureSumPerf(ParallelStreams::iterativeSum, 10_000_000L) + "msecs");
        System.out.println("Parallel을 이용한 합계 = " + Example02.measureSumPerf(ParallelStreams::parallelSum, 10_000_000L) + "msecs");

        // TODO: 이상하게 Parallel이 제일 느림 2021/03/08 10:20 오후
        /**
         * 1. 박싱과 언박싱이 일어난다.
         * 2. 병렬로 실행하기위한 독립적인 단위로 분할하기가 힘들기 때문이다.
         * */
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result : " + sum);

            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
