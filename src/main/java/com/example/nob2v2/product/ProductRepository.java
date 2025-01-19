package com.example.nob2v2.product;

import com.example.nob2v2.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContaining(String name);

    // can be done with custom query !

}
