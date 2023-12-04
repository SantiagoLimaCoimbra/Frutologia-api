package xulep.co.frutologiaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.DTOs.usuario.CreateUserDTO;
import xulep.co.frutologiaapi.entity.User;
import xulep.co.frutologiaapi.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User create(CreateUserDTO data){
        User user = new User();
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPermission(data.getPermission());

        String passwordCrypt = passwordEncoder.encode(data.getPassword());
        user.setPassword(passwordCrypt);

        repository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }
}
