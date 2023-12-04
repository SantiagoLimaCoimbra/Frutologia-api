package xulep.co.frutologiaapi.DTOs.usuario;

import lombok.Data;

@Data
public class LoginResponseDTO {

    private String token;

    public LoginResponseDTO(String token) {
    }
}
