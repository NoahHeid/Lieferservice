package com.example.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/deliveries")
    public ResponseEntity<List> getAllDeliverys(){
        List<Delivery> lieferungen = deliveryService.getAllDeliveries();
        return new ResponseEntity(lieferungen, HttpStatus.OK);
    }
    @PostMapping("/deliveries")
    public ResponseEntity saveDelivery(@RequestBody Delivery delivery){
        deliveryService.save(delivery);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("/deliveries")
    public ResponseEntity deleteDelivery(@RequestParam Long id){
        return deliveryService.deleteDeliveryById(id);
    }
    @PutMapping("/deliveries")
    public ResponseEntity updateDelivery(@RequestParam Long id, @RequestBody Delivery delivery){
        return deliveryService.updateDeliveryById(id, delivery);

    }


}
