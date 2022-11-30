package com.example.lieferservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LieferService {
    @Autowired
    private LieferRepository lieferRepository;

    public List<Lieferung> getAllLieferungen(){
        return lieferRepository.findAll();
    }

    public void save(Lieferung lieferung) {
        lieferRepository.save(lieferung);
    }

    public ResponseEntity deleteLieferungById(Long id) {
        Optional<Lieferung> toDelete = lieferRepository.findById(id);
        if(toDelete.isPresent()) {
            lieferRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Transactional
    public ResponseEntity updateLieferungById(Long id, Lieferung lieferung) {
        Optional<Lieferung> toUpdate = lieferRepository.findById(id);
        if(toUpdate.isPresent()){
            Lieferung l1 = toUpdate.get();
            l1.setName(lieferung.getName());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
