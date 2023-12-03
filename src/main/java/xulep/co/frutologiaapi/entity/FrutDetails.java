package xulep.co.frutologiaapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "FrutDetails")
@Table(name = "FrutDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FrutDetails {

    @Column(name = "id_frut")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
