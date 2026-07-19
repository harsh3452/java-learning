package com.harsh.eCommerce.repo;

import com.harsh.eCommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query()
    List<Product> searchProduct(String keyword);
}