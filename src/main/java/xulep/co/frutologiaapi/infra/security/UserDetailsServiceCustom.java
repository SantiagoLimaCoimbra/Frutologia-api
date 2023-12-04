package xulep.co.frutologiaapi.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.entity.Usuario;
import xulep.co.frutologiaapi.service.UsuarioService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioService.getUserAuthentication(username);
        if(!usuario.isPresent())
            new UsernameNotFoundException("Usuário não encontrado!");

        return new UserDetailsCustom(usuario);
    }
}