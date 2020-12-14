package me.choi.java8study;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:36 오전
 */
public class Foo {
    public static void main(String[] args) {
        // 익명 내부 클래스 anonymous inner class
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("do it");
//            }
//        };
        // 람다로 변경
//        RunSomething runSomething2 = () -> System.out.println("do it");
//        runSomething2.doIt();

        int baseNumber = 20;
        RunSomething runSomething = (number) -> {
            return baseNumber + 10;
        };

        System.out.println(runSomething.doIt(10));
        System.out.println(runSomething.doIt(10));
        System.out.println(runSomething.doIt(10));
    }
}
