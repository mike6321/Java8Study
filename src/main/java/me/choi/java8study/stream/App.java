package me.choi.java8study.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:30 오후
 */
public class App {
    public static void main(String[] args) {
        // TODO: 400 칼로리 미만의 Dish list에 담기 2021/03/09 4:34 오후
        // TODO: 400 칼로리 미만의 Dish list에 담고 이름 저장 2021/03/09 4:36 오후
        List<Dish> lowCaloricDishes = new ArrayList<>();
        List<String> lowCaloricDishesNames = new ArrayList<>();

        for (Dish dish : Dish.menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
                lowCaloricDishesNames.add(dish.getName());
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });


        //출력
        for (Dish lowCaloricDish : lowCaloricDishes) {
            System.out.println(lowCaloricDish.getCalories());
        }
        for (String name : lowCaloricDishesNames) {
            System.out.println(name);
        }


        List<String> streamLowCaloricDishesNames = Dish.menu.stream()
                                                            .filter(d -> d.getCalories() < 400)
                                                            .sorted(Comparator.comparing(Dish::getCalories))
                                                            .map(Dish::getName)
                                                            .collect(Collectors.toList());

        for (String name : streamLowCaloricDishesNames) {
            System.out.println(name);
        }


        List<Dish> vegetarianMenu = Dish.menu.stream()
                                        .filter(dish -> {
                                            System.out.println("filtering " + dish.isVegitarian());
                                            return dish.isVegitarian();
                                        })
                                        .collect(Collectors.toList());

        // TODO: 고유요소 필터링 2021/03/09 9:07 오후
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()
               .forEach(System.out::println);

        // TODO: 스트림 축소 2021/03/09 9:07 오후
        List<Dish> dishes = Dish.menu.stream()
                                     .filter(d -> d.getCalories() > 0)
                                     .limit(3)
                                     .sorted(Comparator.comparingInt(Dish::getCalories))
                                     .collect(Collectors.toList());


        dishes.forEach(d -> {
            System.out.println(d.getName());
        });

        // TODO: 스트림 요소 건너뛰기 2021/03/09 9:09 오후
        List<Dish> dishList = Dish.menu.stream().filter(d -> d.getCalories() > 300)
                                                .skip(2)
                                                .collect(Collectors.toList());

        dishes.forEach(d -> {
            System.out.println(d.getName());
        });

        // TODO: 처음 등장하는 고기요리 필터링 2021/03/09 9:12 오후
        System.out.println("처음 등장하는 고기요리 필터링");
        Dish.menu.stream().filter(d -> d.getType().equals(Type.MEAT))
                          .limit(2)
                          .forEach(f -> System.out.println(f.getName()));


        List<String> mapName = Dish.menu.stream()
                                    .map(Dish::getName)
                                    .collect(Collectors.toList());


        List<String> words = Arrays.asList("Java8", "Lamdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                                        .map(String::length)
                                        .collect(Collectors.toList());
        System.out.println(wordLengths);

        // TODO: 요리명의 길이 알아내기 with map 2021/03/09 9:30 오후
        List<Integer> dishNameLengths = Dish.menu.stream()
                                                .map(Dish::getName)
                                                .map(String::length)
                                                .collect(Collectors.toList());

        System.out.println(dishNameLengths);

        // TODO: 고유의 문자열 구하기 flatMap 2021/03/09 9:37 오후
        List<String> word2 = Arrays.asList("Hello", "World");
        List<String[]> mapWorld = word2.stream()
                                        .map(w -> w.split(""))
                                        .distinct()
                                        .collect(Collectors.toList());
        System.out.println(mapWorld);

        word2.stream()
                .map(w -> w.split(""))
                .map(Arrays::stream)
                .collect(Collectors.toList());

        List<String> flatMapWords = word2.stream()
                                        .map(w -> w.split(""))
                                        .flatMap(Arrays::stream)
                                        .distinct()
                                        .collect(Collectors.toList());

        System.out.println(flatMapWords);

        // TODO: map으로 제곱근 구하기 2021/03/09 9:39 오후
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> productNumber = numberList.stream()
                                                .map(n -> n * n)
                                                .collect(Collectors.toList());

        System.out.println(productNumber);

        // TODO: 숫자 쌍 구하기 2021/03/09 10:28 오후
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        List<int[]> pairs = number1.stream()
                                    .flatMap(i -> number2.stream()
                                            .map(j -> new int[]{i, j}))
                                    .collect(Collectors.toList());
        pairs.stream()
                .forEach(pair -> Arrays.stream(pair)
                                        .forEach(System.out::print));

        pairs.stream()
                .map(pair -> {
                            Arrays.stream(pair)
                                    .forEach(System.out::println);
                            return null;
                        }
                )
                .forEach(dummy -> {});

        // TODO: 조건이 있는 숫자 쌍 구하기 2021/03/09 10:28 오후
        List<int[]> pairs2 = number1.stream()
                                    .flatMap(i -> number2.stream().filter(j -> (i + j) % 3 == 0)
                                            .map(j -> new int[]{i, j}))
                                    .collect(Collectors.toList());

        pairs2.stream()
                .forEach(p -> Arrays.stream(p)
                                    .forEach(System.out::print));

    }
}
