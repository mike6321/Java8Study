package me.choi.java8study.stream.kevin;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:28 오전
 */
public class StreamExample02 {
    public static void main(String[] args) {
        final List<Product> products = Arrays.asList(new Product(1L, "A", new BigDecimal("100.50")),
                                                     new Product(2L, "B", new BigDecimal("23.00")),
                                                     new Product(3L, "C", new BigDecimal("31.45")),
                                                     new Product(4L, "D", new BigDecimal("80.20")),
                                                     new Product(5L, "E", new BigDecimal("7.50")));


    }
}
