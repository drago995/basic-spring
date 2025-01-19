package com.example.nob2v2.mappings;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adress_id")
    private Adress adress;
}
