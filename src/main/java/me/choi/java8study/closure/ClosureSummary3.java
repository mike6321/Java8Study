package me.choi.java8study.closure;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:54 오후
 */
public class ClosureSummary3 {

    public void method() {
        //Effectively final
        int number = 1;

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                //number = 2;
            }
        };
        runnable1.run();

        Runnable runnable2 = () -> {
            //number = 3;
        };
        runnable2.run();
    }

    public static void main(String[] args) {

    }
}
