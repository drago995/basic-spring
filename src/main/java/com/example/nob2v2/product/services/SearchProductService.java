package com.example.nob2v2.product.services;

import com.example.nob2v2.Query;
import com.example.nob2v2.product.ProductRepository;
import com.example.nob2v2.product.model.Product;
import com.example.nob2v2.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {

    private final ProductRepository productRepository;

    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        return ResponseEntity.ok( // 1: Opening for ok
                productRepository.findByNameContaining(name) // 2: findByNameContaining opens & closes here
                        .stream() // No new parentheses
                        .map(ProductDTO::new) // No new parentheses
                        .toList() // No new parentheses
        ); // 3: Closing for ok

    }
}
