package com.example.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getAllDeliveries(){
        return deliveryRepository.findAll();
    }

    public void save(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public ResponseEntity deleteDeliveryById(Long id) {
        Optional<Delivery> toDelete = deliveryRepository.findById(id);
        if(toDelete.isPresent()) {
            deliveryRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity updateDeliveryById(Long id, Delivery delivery) {
        Optional<Delivery> toUpdate = deliveryRepository.findById(id);
        if(toUpdate.isPresent()){
            Delivery l1 = toUpdate.get();
            l1.setName(delivery.getName());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
