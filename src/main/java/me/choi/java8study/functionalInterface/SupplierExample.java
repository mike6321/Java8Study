package me.choi.java8study.functionalInterface;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:58 오후
 */
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> helloSupplier = () -> "hello";
        System.out.println(helloSupplier.get() + "world");

        int number = 3;
//        print(number, String.valueOf(number));
//        print(3, getVeryExpensiveValue());

        printWithSupplier(3, () -> getVeryExpensiveValue());
        printWithSupplier(-1, () -> getVeryExpensiveValue());
        printWithSupplier(-2, () -> getVeryExpensiveValue());

        //remind (Consumer)
        Consumer<String> helloConsumer = (v) -> System.out.println(v + "world");
        helloConsumer.accept("hello");

        //remind (Function)
        Function<String, String> helloFunction = (v) -> v + "world";
        System.out.println(helloFunction.apply("hello"));
    }

    private static void print(int number, String value) {
        if (isOverZero(number, n -> n > 0)) {
            System.out.println("The Value is " + value);
        }
        else {
            System.out.println("Invalid Type");
        }
    }

    private static void printWithSupplier(int number, Supplier value) {
        if (isOverZero(number, n -> n > 0)) {
            System.out.println("The Value is " + value.get());
        }
        else {
            System.out.println("Invalid Type");
        }
    }

    private static <T> boolean isOverZero(T number, Predicate<T> predicate) {
        return predicate.test(number);
    }

    // TODO: 출력 시 3초가 걸린다. 2021/04/04 8:32 오후
    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "junwoo";
    }

}
