package com.example.delivery;

import com.example.delivery.entities.Delivery;
import com.example.delivery.entities.Item;
import com.example.delivery.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getAllDeliveries(){
        return deliveryRepository.findAll();
    }

    public ResponseEntity save(Delivery delivery) {
        Double priceOfElements = getPriceOfElements(delivery);
        if(priceOfElements == -1) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        delivery.setPrice(priceOfElements);
        deliveryRepository.save(delivery);
        return new ResponseEntity<>(delivery, HttpStatus.CREATED);
    }

    private Double getPriceOfElements(Delivery delivery) {
        List<Integer> ids = delivery.getItems().stream().map(Item::getItem).toList();
        ResponseEntity res = sendRequest(ids);
        System.out.println(res.getStatusCode().value());
        if(res.getStatusCodeValue() != HttpStatus.OK.value()){
            return -1.0;
        }
        return (double) res.getBody();
    }

    private static ResponseEntity sendRequest(List<Integer> ids) {
        String url = "http://localhost:8081/get-price-of-elements";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity entity = new HttpEntity(ids, headers);
        ResponseEntity res = RequestHandler.sendRequest(url, entity, HttpMethod.POST);
        return res;
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

    public Delivery getSpecificDelivery(String name) {
        Delivery delivery = deliveryRepository.findByName(name);
        return delivery;
    }

    public List<Delivery> getSpecificDeliveryByPrice(Double price) {
        List<Delivery> deliveries = deliveryRepository.findByPrice(price);
        return deliveries;
    }
}
