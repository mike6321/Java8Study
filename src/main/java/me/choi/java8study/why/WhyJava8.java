package me.choi.java8study.why;

import java.util.Arrays;
import java.util.List;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:39 오후
 */
public class WhyJava8 {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final StringBuilder stringBuilder = new StringBuilder();
        final int size = numbers.size();
        int i = 0;
        
        // TODO: 기존 Iterative 방식  2021/04/04 6:00 오후 
        /**
         * 코드가 장황해지며 실수의 여지가 늘어난다.
         * */
        for (Integer number : numbers) {
            stringBuilder.append(number);
            if (i != size - 1) {
                stringBuilder.append(" : ");
                i++;
                continue;
            }
        }

        System.out.println(stringBuilder);
    }
}
