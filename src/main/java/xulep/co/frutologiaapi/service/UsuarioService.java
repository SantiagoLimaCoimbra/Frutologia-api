package xulep.co.frutologiaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.DTOs.User.CreateUsuarioDTO;
import xulep.co.frutologiaapi.entity.Usuario;
import xulep.co.frutologiaapi.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario create(CreateUsuarioDTO data){
        Usuario user = new Usuario();
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPermission(data.getPermission());

        String passwordCrypt = passwordEncoder.encode(data.getPassword());
        user.setPassword(passwordCrypt);

        repository.save(user);
        return user;
    }

    public Optional<Usuario> getUserAuthentication(String email){
        return repository.findByEmail(email);
    }

}
