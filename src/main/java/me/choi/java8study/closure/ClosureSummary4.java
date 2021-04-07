package me.choi.java8study.closure;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:56 오후
 */
public class ClosureSummary4 {

    int number = 1;

    public void method() {
        int number = 2;

        innerMethod(new Runnable() {
            @Override
            public void run() {
                System.out.println(ClosureSummary4.this.number);
            }
        });

        innerMethod(() -> {
            System.out.println(this.number);
        });
    }

    private void innerMethod(Runnable runnable) {
        runnable.run();
    }

    public static void main(String[] args) {
        ClosureSummary4 summary = new ClosureSummary4();
        summary.method();
    }
}
