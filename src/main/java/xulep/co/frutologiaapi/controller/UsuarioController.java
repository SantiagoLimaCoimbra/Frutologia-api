package xulep.co.frutologiaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xulep.co.frutologiaapi.DTOs.User.CreateUsuarioDTO;
import xulep.co.frutologiaapi.entity.Usuario;
import xulep.co.frutologiaapi.service.UsuarioService;

@RestController
@RequestMapping("users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody CreateUsuarioDTO data){
        try {
            Usuario user = service.create(data);
            return new ResponseEntity(user, HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

}
