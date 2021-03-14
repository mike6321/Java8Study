package me.choi.java8study.optional;

import me.choi.java8study.OnlineClass;
import me.choi.java8study.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:09 오후
 */
public class OptionalExample {

    private static List<OnlineClass> springClasses = new ArrayList<>();
    private static List<OnlineClass> javaClasses = new ArrayList<>();
    private static List<List<OnlineClass>> junwooEvents = new ArrayList<>();

    public static void main(String[] args) {
        init();

        Optional<OnlineClass> spring = springClasses.stream()
                                                    .filter(oc -> oc.getTitle().startsWith("spring"))
                                                    .findFirst();





    }
    private static void init() {
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        javaClasses.add(new OnlineClass(6, "The Java Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code Manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        junwooEvents.add(springClasses);
        junwooEvents.add(javaClasses);
    }
}
