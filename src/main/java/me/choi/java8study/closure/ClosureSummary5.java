package me.choi.java8study.closure;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:16 오후
 */
public class ClosureSummary5 {
    private int number = 0;

    @Override
    public String toString() {
        return "ClosureSummary5{" +
                "number=" + number +
                '}';
    }

    public String toString(String name) {
        return name + "{" +
                "number=" + number +
                '}';
    }

    public void method() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                String anonymous = ClosureSummary5.this.toString("Anonymous");
                System.out.println(anonymous);
            }
        };
        runnable1.run();

        Runnable runnable2 = () -> {
            String lamda = toString("Lamda");
            System.out.println(lamda);
        };
        runnable2.run();
    }

    public static void main(String[] args) {
        ClosureSummary5 summary = new ClosureSummary5();
        summary.method();
    }
}
