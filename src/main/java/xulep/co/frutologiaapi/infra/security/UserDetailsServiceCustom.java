package xulep.co.frutologiaapi.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.entity.Usuario;
import xulep.co.frutologiaapi.service.UsuarioService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = service.getUserAuthentication(username);
        if(!usuario.isPresent())
            new UsernameNotFoundException("Usuário não encontrado");

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.get().getPermission());
        Set<GrantedAuthority> authorities = new HashSet();
        authorities.add(authority);

        User user = new User(usuario.get().getEmail(), usuario.get().getPassword(), authorities);
        return user;
    }

}
