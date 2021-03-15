package me.choi.java8study.stream;

import me.choi.java8study.OnlineClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:36 오후
 */
public class StreamExample04 {
    private static List<OnlineClass> springClasses = new ArrayList<>();
    private static List<OnlineClass> javaClasses = new ArrayList<>();
    private static List<List<OnlineClass>> junwooEvents = new ArrayList<>();

    public static void main(String[] args) {
        init();

        // TODO: [Spirng으로 시작하는 수업]
		springClasses.stream().filter(f -> f.getTitle().startsWith("spring"))
							  .map(m -> m.getTitle())
							  .forEach(System.out::println);

		List<Integer> numbers = Arrays.asList(3, 2, 1, 9, 5, 6, 7, 8, 4, 10);
		List<Integer> reversedNumbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		reversedNumbers.forEach(System.out::print);

        // TODO: [close 되지 않은 수업]
		List<OnlineClass> notClosed = Stream.concat(javaClasses.stream(), springClasses.stream())
											.filter(p -> p.isClosed() == false)
											.collect(Collectors.toList());
		notClosed.stream().forEach(s -> {
			System.out.println(s.isClosed());
			System.out.println(s.getTitle());
		});

        // TODO: [수업 이름만 모아서 스트림 만들기]
		Stream.concat(springClasses.stream(), javaClasses.stream())
			  .map(OnlineClass::getTitle)
			  .collect(Collectors.toList())
			  .forEach(System.out::println);

        // TODO: [두 수업 목록에 들어있는 모든 수업 아이디 출력]
	    junwooEvents.stream()
	    	        .flatMap(f -> f.stream().map(OnlineClass::getId))
	    	        .forEach(System.out::println);

        // TODO: [10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만]
	    Stream.iterate(10, f -> {
	    	return f + 1;
	    }).skip(10).limit(10).forEach(System.out::println);

	    Stream.iterate(10, f -> f + 1)
	    	  .skip(10)
	    	  .limit(10)
	    	  .forEach(System.out::println);

        // TODO: [자바 수업 중에 Test가 들어있는 수업이 있는지 확인]
		boolean isInTest = javaClasses.stream()
									  .anyMatch(p -> p.getTitle().contains("Test"));
		System.out.println(isInTest);

		//TODO: [스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List 만들기]
		springClasses.stream()
					 .filter(n -> n.getTitle().contains("spring"))
					 .collect(Collectors.toList())
					 .forEach(f -> {
						 System.out.println(f.getTitle());
					 });
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
