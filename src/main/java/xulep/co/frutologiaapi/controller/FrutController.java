package xulep.co.frutologiaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import xulep.co.frutologiaapi.DTOs.Frut.CreateFrutDTO;
import xulep.co.frutologiaapi.DTOs.Frut.UpdateFrutDTO;
import xulep.co.frutologiaapi.entity.Frut;
import xulep.co.frutologiaapi.service.FrutService;

import java.util.List;

@RestController
@RequestMapping("fruits")
public class FrutController {

    @Autowired
    private FrutService service;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody CreateFrutDTO data){
        try {
            Frut frut = service.create(data);
            return new ResponseEntity(frut, HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            List<Frut> list = service.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        Frut frut = service.findOne(id);
        return ResponseEntity.ok(frut);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> update(@RequestBody UpdateFrutDTO data){
        try {
            var frut = service.update(data);
            return new ResponseEntity<>("Fruta atualizada", HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            service.delete(id);
            return new ResponseEntity<>("Fruta removida", HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

}
