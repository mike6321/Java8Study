package me.choi.java8study.closure;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:02 오후
 */
public class Closure3 {

//    int number = 10;

    public static void main(String[] args) {
        int number = 10;
        new Closure3().method();

        Runnable runnable = () -> {
            System.out.println(number);
        };

        Runnable runnable1 = new Runnable() {
            int number = 10;
            @Override
            public void run() {
                System.out.println(number);
            }
        };
    }

    private void method() {
        int number = 10;

        Runnable runnable = () -> {
//            int number = 10;
        };

        Runnable runnable1 = new Runnable() {
            int number = 20;

            @Override
            public void run() {
//                int number = 20;
                number = 21;
//                number = 23;
                System.out.println(number);
            }
        };

        runnable1.run();


    }
}
