package com.example.delivery;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="delivery")
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "deliveryname")
    private String name;

    @Column(name = "price")
    private Double price;
}
