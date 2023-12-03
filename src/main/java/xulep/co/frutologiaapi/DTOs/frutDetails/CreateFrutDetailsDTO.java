package xulep.co.frutologiaapi.DTOs.frutDetails;

import lombok.Data;

@Data
public class CreateFrutDetailsDTO {

    //@NotBlank
    private Integer calories;
    private Double fat;
    private Double sugar;
    private Double carbohydrates;
    private Double protein;
}
