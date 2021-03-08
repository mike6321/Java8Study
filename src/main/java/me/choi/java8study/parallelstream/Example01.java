package me.choi.java8study.parallelstream;

import java.util.stream.Stream;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:47 오후
 */
public class Example01 {

    public static void main(String[] args) {
        long streamResult = Example01.sequentialSum(10);
        long basicResult = Example01.basicSequentialSum(10);
        long parallelResult = Example01.parallelSum(10);

        System.out.println(streamResult);
        System.out.println(basicResult);
        System.out.println(parallelResult);
    }

    // TODO: stream을 이용한 누적 합계 구하기 2021/03/08 9:52 오후
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)   // 무한 자연수 스트림 생성
                .limit(n)   // n개 이하로 제한
                .reduce(0L, Long::sum); // 모든 숫자를 더하는 스트림 리듀싱 연
    }

    // TODO: 기본 자바 누적합계 구하기 2021/03/08 9:53 오후
    public static long basicSequentialSum(long n) {
        long result = 0;

        for (long i = 1L; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
