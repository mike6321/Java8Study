package me.choi.java8study;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:17 오전
 */
public class ThisDifference {
    public static void main(String[] args) {
        new ThisDifference().print();
    }

    private void print() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                veriftRunnable(this);
            }
        };
        runnable.run();

        Runnable lamdaExpression = () -> veriftRunnable(this);
        lamdaExpression.run();
    }

    private void veriftRunnable(Object obj) {
        //System.out.println(obj instanceof ThisDifference);
        System.out.println(obj instanceof Runnable);
    }
}
