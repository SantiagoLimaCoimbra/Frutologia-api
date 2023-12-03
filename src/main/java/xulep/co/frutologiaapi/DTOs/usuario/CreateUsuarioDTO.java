package xulep.co.frutologiaapi.DTOs.usuario;

import lombok.Data;

@Data
public class CreateUsuarioDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String permission;

}
