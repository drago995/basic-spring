package com.example.nob2v2.exceptions;

import com.example.nob2v2.product.model.Product;
import lombok.Getter;

@Getter
public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product not found"),
    NAME_REQUIRED("Name is required"),
    DESCRIPTION_LENGTH("Description must be 20 characters"),
    PRICE_CANNON_BE_NEGATIVE("Price cannot be negative"),
    ITEM_DESCRIPTION_CANNOT_BE_EMPTY("Product description can not be empty"),
    ITEM_CATEGORY_DOES_NOT_EXIST("Category does not exist"),
    DESCRIPTION_CONTAINS_PROFANITY("Description contains profanity");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
