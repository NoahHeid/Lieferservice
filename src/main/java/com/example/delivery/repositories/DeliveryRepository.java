package com.example.delivery.repositories;

import com.example.delivery.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findByName(String name);
    List<Delivery> findByPrice(Double price);
}
