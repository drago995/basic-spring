package com.example.nob2v2.product.services;

import com.example.nob2v2.Command;
import com.example.nob2v2.exceptions.ErrorMessages;
import com.example.nob2v2.exceptions.ProductNotValidException;
import com.example.nob2v2.product.ProductRepository;
import com.example.nob2v2.product.model.Product;
import com.example.nob2v2.product.model.ProductDTO;

import com.example.nob2v2.product.validators.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        // validate
       // ProductValidator.execute(product);


        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }

}


