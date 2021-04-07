package me.choi.java8study.closure;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:27 오후
 */
public class ClosureSummary2 {
    private int number;

    public void anonymousMethod() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                number = 1;
            }
        };
        runnable.run();
    }

    public void lamdaMethod() {
        Runnable runnable = () -> {
            number = 2;
        };
        runnable.run();
    }

    public static void main(String[] args) {
        ClosureSummary2 summary = new ClosureSummary2();
        summary.anonymousMethod();
        summary.lamdaMethod();
        System.out.println(summary.number);
    }
}
