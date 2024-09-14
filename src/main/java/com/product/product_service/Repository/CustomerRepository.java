package com.product.product_service.Repository;

import com.product.product_service.Entity.CustomerEntity;
import com.product.product_service.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity , Long> {

    Optional<CustomerEntity> findByCustomerId(String customerId);
}
