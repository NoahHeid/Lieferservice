package com.example.delivery;

import com.example.delivery.entities.Delivery;
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
    @GetMapping("/delivery")
    public ResponseEntity getSpecificDelivery(@RequestParam String name){
        Delivery delivery = deliveryService.getSpecificDelivery(name);
        return new ResponseEntity(delivery, HttpStatus.OK);
    }

    @GetMapping("/deliveries-by-price")
    public ResponseEntity<List> getSpecificDeliveryByPrice(@RequestParam Double price){
        List<Delivery> deliveries = deliveryService.getSpecificDeliveryByPrice(price);
        return new ResponseEntity(deliveries, HttpStatus.OK);
    }
    @PostMapping("/delivery")
    public ResponseEntity saveDelivery(@RequestBody Delivery delivery){
        return deliveryService.save(delivery);
    }
    @DeleteMapping("/delivery")
    public ResponseEntity deleteDelivery(@RequestParam Long id){
        return deliveryService.deleteDeliveryById(id);
    }
    @PutMapping("/delivery")
    public ResponseEntity updateDelivery(@RequestParam Long id, @RequestBody Delivery delivery){
        return deliveryService.updateDeliveryById(id, delivery);

    }


}
