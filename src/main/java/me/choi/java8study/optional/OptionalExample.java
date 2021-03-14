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

        // TODO: Optional - isPresent 2021/03/14 7:51 오후
        Optional<OnlineClass> spring = springClasses.stream()
                                                    .filter(oc -> oc.getTitle().startsWith("spring"))
                                                    .findFirst();

        boolean present = spring.isPresent();
        System.out.println(present);

        // TODO: Optional - get 2021/03/14 7:52 오후
        /**
         * return 이 Optional Type이 아니다.
         * 가급적이면 get을 사용하지 말자!
         * */
        if (spring.isPresent()) {
            OnlineClass onlineClass = spring.get();
            System.out.println(onlineClass.getTitle());
        }

        // TODO: Optional - ifPresent 2021/03/14 7:57 오후
        System.out.println("***************ifPresent***************");
        spring.ifPresent(OnlineClass::getTitle);

        // TODO: orElse 2021/03/14 7:59 오후
        /**
         * 있던 없던 무조건 탄다.
         * */
        System.out.println("***************orElse***************");
        spring.orElse(createNewClasee());

        // TODO: orElseGet 2021/03/14 8:01 오후
        /**
         * 없을때만 탄다.
         * */
        System.out.println("***************orElseGet***************");
        spring.orElseGet(() -> createNewClasee());

        OnlineClass onlineClass = spring.orElseThrow();

    }

    private static OnlineClass createNewClasee() {
        System.out.println("create New Class");
        return new OnlineClass(10, "New Class", false);
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
