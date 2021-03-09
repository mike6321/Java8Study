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
    }
}
