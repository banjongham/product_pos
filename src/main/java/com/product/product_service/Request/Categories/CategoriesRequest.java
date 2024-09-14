package com.product.product_service.Request.Categories;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CategoriesRequest {

    private int id;
    private String categoriesName;
    private String categoriesImage;
    private String active;
}
