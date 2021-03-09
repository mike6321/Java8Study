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


    }
}
