package com.example.nob2v2.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id")
    private Integer id;
    @NotNull(message = "Name is required")
    @Column(name = "name")
    private String name;
    @Size(min = 20, message = "Description must be minimum 20 chars long")
    @Column(name = "description")
    private String description;
    @PositiveOrZero(message = "Price must be positive")
    @Column(name = "price")
    private Double price;


}
