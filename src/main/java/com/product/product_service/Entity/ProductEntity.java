package com.product.product_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_sku")
    private String productSku;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_cost")
    private BigDecimal productCost;

    @Column(name = "product_image")
    private String productImage;
}
