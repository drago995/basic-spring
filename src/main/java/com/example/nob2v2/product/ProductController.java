package com.example.nob2v2.product;

import com.example.nob2v2.exceptions.ProductNotFoundException;
import com.example.nob2v2.product.model.ErrorResponse;
import com.example.nob2v2.product.model.Product;
import com.example.nob2v2.product.model.ProductDTO;
import com.example.nob2v2.product.model.UpdateProductCommand;
import com.example.nob2v2.product.services.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    private final CreateProductService createProductService;
    private final DeleteProductService deleteProductService;
    private final UpdateProductService updateProductService;
    private final GetProductsService getProductsService;
    private final GetProductService getProductService;
    private final SearchProductService searchProductService;
    public ProductController(CreateProductService createProductService,
                             DeleteProductService deleteProductService,
                             UpdateProductService updateProductService,
                             GetProductsService getProductsService,
                             GetProductService getProductService,
                             SearchProductService searchProductService) {
        this.createProductService = createProductService;
        this.deleteProductService = deleteProductService;
        this.updateProductService = updateProductService;
        this.getProductsService = getProductsService;
        this.getProductService = getProductService;
        this.searchProductService = searchProductService;
    }




    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {

        return createProductService.execute(product);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>>  getProduct(){
        return getProductsService.execute(null);


    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
            return getProductService.execute(id);

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO>  updateProduct(@PathVariable Integer id, @RequestBody Product product){


        return updateProductService.execute(new UpdateProductCommand(id, product));

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void>  deleteProduct(@PathVariable Integer id){
        return deleteProductService.execute(id);


    }
    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> searchProductsByName(@RequestParam String name){
        return searchProductService.execute(name);
    }

}
