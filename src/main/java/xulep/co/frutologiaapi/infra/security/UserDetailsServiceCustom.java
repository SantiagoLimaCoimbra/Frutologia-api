package xulep.co.frutologiaapi.infra.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.entity.Usuario;
import xulep.co.frutologiaapi.service.UsuarioService;

import java.util.Optional;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final UsuarioService usuarioService;

    public UserDetailsServiceCustom(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioService.getUserAuthentication(username);
        if(!usuario.isPresent())
            new UsernameNotFoundException("Usuário não encontrado!");

        return new UserDetailsCustom(usuario);
    }
}
