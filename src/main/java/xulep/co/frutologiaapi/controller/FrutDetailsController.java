package xulep.co.frutologiaapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import xulep.co.frutologiaapi.DTOs.frutDetails.CreateFrutDetailsDTO;
import xulep.co.frutologiaapi.DTOs.frutDetails.UpdateFrutDetailsDTO;
import xulep.co.frutologiaapi.entity.FrutDetails;
import xulep.co.frutologiaapi.service.FrutDetailsService;

import java.util.List;

@RestController
@RequestMapping("fruitsDetails")
public class FrutDetailsController {

    @Autowired
    private FrutDetailsService service;

    @PostMapping
    @Transactional
    @Operation(summary = "Adiciona detalhes novos no banco sobre uma fruta")
    @Tag(name = "Adiciona detalhes")
    public ResponseEntity<?> create(@RequestBody CreateFrutDetailsDTO data){
        try {
            FrutDetails frutD = service.create(data);
            return new ResponseEntity(frutD, HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Retorna uma lista de todos os detalhes das frutas cadastradas")
    @Tag(name = "Buscar todos os detalhes das frutas")
    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            List<FrutDetails> list = service.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_GATEWAY);
        }
    }

    @Operation(summary = "Retorna os detalhes que corresponde ao id especificado no endpoint")
    @Tag(name = "Buscar detalhes por id")
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        FrutDetails frutD = service.findOne(id);
        return ResponseEntity.ok(frutD);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Retorna os detalhes que corresponde ao id especificado no endpoint possibilitando sua edição")
    @Tag(name = "Editar detalhes")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdateFrutDetailsDTO data){
        try {
            var frutD = service.update(id, data);
            return new ResponseEntity<>("Fruta atualizada", HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Deleta os detalhes que corresponde ao id especificado no endpoint")
    @Tag(name = "Remover detalhes")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            service.delete(id);
            return new ResponseEntity<>("Fruta removida", HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

}
