package xulep.co.frutologiaapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xulep.co.frutologiaapi.DTOs.usuario.CreateUsuarioDTO;
import xulep.co.frutologiaapi.entity.Usuario;
import xulep.co.frutologiaapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    @Operation(summary = "Adiciona um novo usuario no banco")
    @Tag(name = "Adicionar usuário")
    public ResponseEntity<?> salvar(@RequestBody CreateUsuarioDTO data){
        Usuario usuario = usuarioService.create(data);
        return new ResponseEntity(usuario, HttpStatus.CREATED);
    }

}