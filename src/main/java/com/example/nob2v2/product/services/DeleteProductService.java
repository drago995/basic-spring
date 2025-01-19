package com.example.nob2v2.product.services;

import com.example.nob2v2.Command;
import com.example.nob2v2.exceptions.ProductNotFoundException;
import com.example.nob2v2.product.ProductRepository;
import com.example.nob2v2.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {
    private ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Product> productOptional = productRepository.findById(input);
        if(productOptional.isPresent()){
            productRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        throw new ProductNotFoundException();
    }
}
