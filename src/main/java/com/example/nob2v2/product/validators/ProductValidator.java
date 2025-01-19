package com.example.nob2v2.product.validators;

import com.example.nob2v2.exceptions.ErrorMessages;
import com.example.nob2v2.exceptions.ProductNotValidException;
import com.example.nob2v2.product.model.Product;
import org.springframework.util.StringUtils;

public class ProductValidator {
    public ProductValidator() {
    }

    public static void execute(Product product){
        if(StringUtils.isEmpty(product.getName())){
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());

        }

        if(product.getDescription().length() < 30){
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }
        if(product.getPrice() == null || product.getPrice() < 0.00){
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNON_BE_NEGATIVE.getMessage());
        }


    }
}
