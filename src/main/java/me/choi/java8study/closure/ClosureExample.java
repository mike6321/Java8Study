package me.choi.java8study.closure;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 3:57 오전
 */
public class ClosureExample {
    private int number = 999;

    public static void main(String[] args) {
//        final int number = 100;
        // TODO: 값을 수정하면 에러가 발생한다. 2021/04/03 12:49 오후
//        number = 2;

        new ClosureExample().test1();
    }

    private void test1() {
        int number = 100;
        System.out.println("Anonymous Class");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
                System.out.println(ClosureExample.this.number);
            }
        };
        runnable.run();

        System.out.println("Lamda Expression");
        Runnable runnable1 = () -> {
            System.out.println(number);
        };
        runnable1.run();

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        });

        testClosure("Lamda", () -> System.out.println(number));
    }

    public static void testClosure(final String name, final Runnable runnable) {
        System.out.println("*****************************");
        System.out.print(name + " : ");
        runnable.run();
        System.out.println("*****************************");
    }
}
