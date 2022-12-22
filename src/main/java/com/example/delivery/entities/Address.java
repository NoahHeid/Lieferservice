package com.example.delivery.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "postcode", nullable = false)
    private String postcode;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "housenumber", nullable = false)
    private String housenumber;


}
