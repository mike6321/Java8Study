package me.choi.java8study.functionalInterface;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:09 오후
 */
public class LazyEvaluationExample {
    public static void main(String[] args) {
        // TODO: 음수인지 양수인지 판단 2021/04/04 9:10 오후

        //일반 로직
//        long start = System.currentTimeMillis();
//        isPositive(veryExpensiveOperation(3), "Correct!");
//        isPositive(veryExpensiveOperation(-1), "Correct!");
//        isPositive(veryExpensiveOperation(-2), "Correct!");
//
//        System.out.println((System.currentTimeMillis() - start) / 1000 + "초 걸렸네요..!");

        //supplier 사용
        long start = System.currentTimeMillis();
        isPositive(3, () -> String.valueOf(veryExpensiveOperation(3)));
        isPositive(-1, () -> String.valueOf(veryExpensiveOperation(-1)));
        isPositive(-2, () -> String.valueOf(veryExpensiveOperation(-2)));

        System.out.println((System.currentTimeMillis() - start) / 1000 + "초 걸렸네요..!");
    }

    private static void isPositive(int number, String value) {
        if (judge(number, n -> n > 0)) {
            System.out.println("message : " + value);
        }
        else {
            System.out.println("Invalid");
        }
    }

    private static void isPositive(int number, Supplier<String> valueSupplier) {
        if (judge(number, n -> n > 0)) {
            System.out.println("message : " + valueSupplier);
        }
        else {
            System.out.println("Invalid");
        }
    }

    private static <T> boolean judge(T number, Predicate<T> predicate) {
        return predicate.test(number);
    }

    private static int veryExpensiveOperation(int number)  {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return number;
    }
}
