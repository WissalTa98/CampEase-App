package com.wissal.microproduct.entity;

import com.wissal.microproduct.enumeration.ProductCategory;
import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Setter(AccessLevel.NONE)
    private Integer idProduct;
    private String name;

    private String description;
    private String state;

    private double price;
    private boolean available;
    private  double size;
    private  double weight ;
    private String color;
    private ProductCategory category;
}
