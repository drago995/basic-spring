package com.example.nob2v2.product.services;

import com.example.nob2v2.Query;
import com.example.nob2v2.product.ProductRepository;
import com.example.nob2v2.product.model.Product;
import com.example.nob2v2.product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTOs = products.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productsDTOs);
    }
}
