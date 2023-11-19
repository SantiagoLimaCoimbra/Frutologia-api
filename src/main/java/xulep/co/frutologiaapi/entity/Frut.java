package xulep.co.frutologiaapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Frut")
@Table(name = "Frut")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Frut {

    @Column(name = "id_frut")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_frut")
    private String name;

}
