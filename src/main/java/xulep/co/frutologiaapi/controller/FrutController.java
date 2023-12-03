package xulep.co.frutologiaapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import xulep.co.frutologiaapi.DTOs.frut.CreateFrutDTO;
import xulep.co.frutologiaapi.DTOs.frut.UpdateFrutDTO;
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
    @Operation(summary = "Adiciona uma fruta nova no banco")
    @Tag(name = "Adicionar fruta")
    public ResponseEntity<?> create(@RequestBody CreateFrutDTO data){
        try {
            Frut frut = service.create(data);
            return new ResponseEntity(frut, HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @Operation(summary = "Retorna uma lista com todas as frutas cadastradas")
    @Tag(name = "Buscar todas as frutas")
    public ResponseEntity<?> findAll(){
        try {
            List<Frut> list = service.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna a fruta que corresponde ao id especificado no endpoint")
    @Tag(name = "Buscar fruta por id")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        Frut frut = service.findOne(id);
        return ResponseEntity.ok(frut);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Retorna a fruta que corresponde ao id especificado no endpoint possibilitando sua edição")
    @Tag(name = "Editar fruta")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdateFrutDTO data){
        try {
            var frut = service.update(id, data);
            return new ResponseEntity<>("Fruta atualizada", HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Deleta a fruta que corresponde ao id especificado no endpoint")
    @Tag(name = "Remover fruta")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            service.delete(id);
            return new ResponseEntity<>("Fruta removida", HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

}
