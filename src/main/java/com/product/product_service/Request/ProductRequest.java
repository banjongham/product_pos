package com.product.product_service.Request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private int id;
    private String productName;
    private String sku;
    private BigDecimal price;
}
