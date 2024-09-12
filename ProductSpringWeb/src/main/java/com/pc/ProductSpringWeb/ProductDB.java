package com.pc.ProductSpringWeb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDB extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByType(String type);
    List<Product> findByPlace(String place);
    List<Product> findByWarranty(int warranty);
}
