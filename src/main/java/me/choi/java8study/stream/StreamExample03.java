package me.choi.java8study.stream;

import me.choi.java8study.Trader;
import me.choi.java8study.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:10 오후
 */
public class StreamExample03 {
    private static List<Transaction> transaction;

    public static void main(String[] args) {
        init();

        // TODO: [2011년에 일어난 모든 트랜잭션을 찾아서 값을 오름차순으로 정렬하시오]
		transaction.stream()
					.filter(y -> y.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.map(v -> v.getValue())
					.forEach(System.out::println);

        // TODO: [거래자가 근무하는 모든 도시를 중복 없이 나열하시오]
		transaction.stream().map(t -> t.getTrader().getName())
							.distinct()
							.sorted()
							.forEach(System.out::println);

        // TODO: [케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오]
		transaction.stream().filter(c -> c.getTrader().getCity().equals("Cambridge"))
							.map(n -> n.getTrader().getName())
							.sorted()
							.distinct()
							.forEach(System.out::println);

        // TODO: [모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하시오]
		transaction.stream().map(n -> n.getTrader().getName())
						    .sorted()
						    .forEach(System.out::println);

        // TODO: [밀라노에 거래자가 있는가?]
		boolean isInMario = transaction.stream()
				   					   .anyMatch(m -> m.getTrader().getCity().equals("Milan"));
		System.out.println(isInMario);

        // TODO: [케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오]
		transaction.stream()
				   .filter(c -> c.getTrader().getCity().equals("Cambridge"))
				   .map(v -> v.getValue())
				   .collect(Collectors.toList())
				   .forEach(System.out::println);

        // TODO: [전체 트랜잭션 중 최댓값은 얼마인가?]
		Optional<Integer> max = transaction.stream()
								   		   .filter(c -> c.getTrader().getCity().equals("Cambridge"))
								   		   .max(Comparator.comparing(Transaction::getValue))
								   		   .map(m -> m.getValue());
		System.out.println(max.get());

        // TODO: [전체 트랜잭션 중 최솟값은 얼마인가?]
		int min = transaction.stream()
					.map(m -> m.getValue())
					.reduce(0, Integer::min);
		System.out.println(min);

        // TODO: [거래자가 근무하는 모든 도시를 중복 없이 나열하시오]
		transaction.stream()
				   .map(c -> c.getTrader().getCity())
				   .distinct()
				   .forEach(System.out::println);

    }

    public static void init() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transaction = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

    }
}