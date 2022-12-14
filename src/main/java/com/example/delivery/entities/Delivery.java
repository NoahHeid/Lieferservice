package com.example.delivery.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="delivery")
@Getter
@Setter
@ToString
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameofcustomer", nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany (cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="delivery", orphanRemoval = true)
    private Set<Item> items;

    @Column(name = "price")
    private Double price;


}
