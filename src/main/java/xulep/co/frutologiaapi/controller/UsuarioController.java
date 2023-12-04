package xulep.co.frutologiaapi.controller;

import br.senai.sc.edu.aulaapi.model.Usuario;
import br.senai.sc.edu.aulaapi.model.dto.NovoUsuario;
import br.senai.sc.edu.aulaapi.service.UsuarioService;
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
    public ResponseEntity<?> salvar(@RequestBody CreateUsuarioDTO data){
        Usuario usuario = usuarioService.create(data);
        return new ResponseEntity(usuario, HttpStatus.CREATED);
    }

}