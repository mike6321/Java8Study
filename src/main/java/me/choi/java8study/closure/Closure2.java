package me.choi.java8study.closure;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:50 오전
 */
public class Closure2 {
    private int number = 100;
    public static void main(String[] args) {
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(number);
//            }
//        };
//        runnable1.run();
//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(number);
//            }
//        };
//        runnable1.run();
//        Runnable runnable3 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(number);
//            }
//        };
//        runnable1.run();
//        Runnable runnable4 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(number);
//            }
//        };
//        runnable1.run();

//        Runnable runnable5 = () -> System.out.println(number);

        new Closure2().test();
    }
    private void test() {

        int number = 3;

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        };
        runnable1.run();

        Runnable runnable = () -> System.out.println(number);
        runnable.run();

        Runnable runnable2 = () -> {
//          int number = 3;
        };

    }
}
