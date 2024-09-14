package com.product.product_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "categories")
@AllArgsConstructor
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_image")
    private String categoryImage;

    @Column(name = "active")
    private String active;

    @Column(name = "create_by")
    private int createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private int updateBy;

    @Column(name = "update_date")
    private Date updateDate;
}
