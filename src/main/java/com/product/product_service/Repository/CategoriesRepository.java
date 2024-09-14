package com.product.product_service.Repository;

import com.product.product_service.Entity.CategoriesEntity;
import com.product.product_service.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity , Integer> {

    //Optional<CategoriesEntity> deleteByCategoriesName(String categoriesName);
}
