package com.example.nob2v2.product.headers;

import com.example.nob2v2.product.model.Product;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false, defaultValue = "US") String region){
    if(region.equals("US")) return "BALD EAGLE FREEDOM";

    if(region.equals("CAN"))    return "MAPLE SYRUP";

    return "COUNTRY NOT SUPPORTED";

    }

    @GetMapping(value = "/header/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct(){
        Product p = new Product();
        p.setId(1);
        p.setName("Super great product");
        p.setDescription("blablablaasddddddddddddddddddddddddddd");

        return ResponseEntity.ok(p);


    }
}
