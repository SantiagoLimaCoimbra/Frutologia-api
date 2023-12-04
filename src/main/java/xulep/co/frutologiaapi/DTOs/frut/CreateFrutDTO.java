package xulep.co.frutologiaapi.DTOs.frut;

import lombok.Data;

@Data
public class CreateFrutDTO {

    //@NotBlank
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

