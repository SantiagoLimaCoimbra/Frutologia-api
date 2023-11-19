package xulep.co.frutologiaapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Usuario")
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Column(name = "id_user")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_user")
    private String name;

    @Column(name = "email_user")
    private String email;

    @Column(name = "password_user")
    private String password;

    @Column(name = "permission_user")
    private String permission;

}
