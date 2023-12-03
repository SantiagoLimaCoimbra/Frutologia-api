package xulep.co.frutologiaapi.DTOs.Frut;

import lombok.Data;

@Data
public class UpdateFrutDTO {

    private Long id;
    private String name;
    private String family;
    private String order;
    private String genus;
    private Integer calories;
    private Double fat;
    private Double sugar;
    private Double carbohydrates;
    private Double protein;

}
