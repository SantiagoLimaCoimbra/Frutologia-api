package xulep.co.frutologiaapi.DTOs.usuario;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String email;
    private String password;
}
