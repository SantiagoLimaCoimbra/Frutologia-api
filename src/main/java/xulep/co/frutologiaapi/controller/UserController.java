package xulep.co.frutologiaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xulep.co.frutologiaapi.DTOs.usuario.AuthenticationDTO;
import xulep.co.frutologiaapi.DTOs.usuario.CreateUserDTO;
import xulep.co.frutologiaapi.DTOs.usuario.DataAuthenticationDTO;
import xulep.co.frutologiaapi.DTOs.usuario.LoginResponseDTO;
import xulep.co.frutologiaapi.entity.User;
import xulep.co.frutologiaapi.infra.security.TokenService;
import xulep.co.frutologiaapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateUserDTO data){
        User user = userService.create(data);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
