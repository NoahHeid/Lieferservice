package com.example.lieferservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LieferController {

    @Autowired
    private LieferService lieferService;

    @GetMapping("/lieferungen")
    public ResponseEntity<List> getAllLieferung(){
        List<Lieferung> lieferungen = lieferService.getAllLieferungen();
        return new ResponseEntity(lieferungen, HttpStatus.OK);
    }
    @PostMapping("/lieferung")
    public ResponseEntity saveLieferung(@RequestBody Lieferung lieferung){
        lieferService.save(lieferung);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("/lieferung")
    public ResponseEntity deleteLieferung(@RequestParam Long id){
        return lieferService.deleteLieferungById(id);
    }
    @PutMapping("/lieferung")
    public ResponseEntity updateLieferung(@RequestParam Long id, @RequestBody Lieferung lieferung){
        return lieferService.updateLieferungById(id, lieferung);

    }


}
