package xulep.co.frutologiaapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Frut")
@Table(name = "frut")
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

    @Column(name = "family_frut")
    private String family;

    @Column(name = "order_frut")
    private String order;

    @Column(name = "genus_frut")
    private String genus;

    @Column(name = "calories_frut")
    private Integer calories;

    @Column(name = "fat_frut")
    private Double fat;

    @Column(name = "sugar_frut")
    private Double sugar;

    @Column(name = "carbohydrates_frut")
    private Double carbohydrates;

    @Column(name = "protein_frut")
    private Double protein;

}