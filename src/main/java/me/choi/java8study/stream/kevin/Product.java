package me.choi.java8study.stream.kevin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:26 오전
 */
@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderedItem {
    private Long id;
    private Product product;
    private int quantity;
}

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderedItem> items;
}
