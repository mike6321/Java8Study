package me.choi.java8study.stream;

import me.choi.java8study.Trader;
import me.choi.java8study.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:10 오후
 */
public class StreamExample03 {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // TODO: 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오 2021/03/14 8:12 오후
        List<Transaction> transactions1 = transactions.stream()
                                                        .filter(y -> y.getYear() == 2011)
                                                        .sorted(Comparator.comparing(Transaction::getValue))
                                                        .collect(Collectors.toList());

        // TODO: 거래자가 근무하는 모든 도시를 중복 없이 나열하시오 2021/03/14 8:16 오후
        List<String> transactions2 = transactions.stream()
                                                .map(c -> c.getTrader().getCity())
                                                .distinct()
                                                .collect(Collectors.toList());

        // TODO: 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오 2021/03/14 8:19 오후
        List<Trader> transactions3 = transactions.stream()
                                                .map(Transaction::getTrader)
                                                .filter(c -> c.getCity().equals("Cambridge"))
                                                .distinct()
                                                .sorted(Comparator.comparing(Trader::getName))
                                                .collect(Collectors.toList());



    }
}