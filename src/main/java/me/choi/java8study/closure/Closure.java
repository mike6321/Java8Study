package me.choi.java8study.closure;

import java.util.function.Function;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * someMethod(number, v -> v * number);
 * someMethod(7, v -> v * 100);
 * someMethod(7, v -> v * number);
 * someMethod(number, v -> v * number);
 * Time : 10:47 오후
 */
public class Closure {

    private int number = 999;

    public static void main(String[] args) {
        new Closure().test3();
    }

    private void test1() {
        int number = 777;

        testClosure("Anonymous Runnable", new Runnable() {
            @Override
            public void run() {
                System.out.println("(Anonymous)this.toString() : " + this.toString());
            }
        });
        testClosure("Anonymous Runnable", new Runnable() {
            @Override
            public void run() {
                System.out.println("(Anonymous)Closure.this.toString() : " + Closure.this.toString());
            }
        });
        testClosure("LamdaExpression Runnable", () -> System.out.println("(Lamda)this.toString() : " + this.toString()));


//        testClosure("Anonymous Runnable", new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Closure.this.number);
//            }
//        });
//        testClosure("LamdaExpression Runnable", () -> System.out.println(this.number));
    }

    private void test2() {
        testClosure("Anonymous Runnable", new Runnable() {
            @Override
            public void run() {
                System.out.println("(Anonymous)this.toString() : " + Closure.this.toString("TEST"));
//                System.out.println("(Anonymous)this.toString() : " + this.toString("TEST"));
            }
        });

        testClosure("LamdaExpression Runnable", () -> System.out.println("(Lamda)this.toString() : " + this.toString("TEST")));
    }

    private void test3() {

        System.out.println("Closure calling toString()" + toString());
        System.out.println("Closure calling toString(T value)" + toString("Hello"));



        testClosure("Anonymous Runnable", new Runnable() {
            @Override
            public void run() {
                System.out.println("Closure calling toString()" + toString());
//                System.out.println("Closure calling toString()" + toString("hello"));
            }
        });
        testClosure("LamdaExpression Runnable", () -> System.out.println("Closure calling toString()" + toString()));
    }

    @Override
    public String toString() {
        return "Closure{" +
                "number=" + number +
                '}';
    }

    public static <T> T toString(T value) {
        return (T)("The value is " + String.valueOf(value));
    }

    private static void testClosure(final String name, final Runnable runnable) {
        System.out.println("*************************");
        System.out.print(name + " : ");
        runnable.run();
        System.out.println("*************************");
    }

    private static void someMethod(final int num, final Function<Integer, Integer> function) {
        Integer apply = function.apply(num);
        System.out.println(apply);
    }
}
