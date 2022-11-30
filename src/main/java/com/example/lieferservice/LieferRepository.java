package com.example.lieferservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LieferRepository extends JpaRepository<Lieferung, Long> {

}
