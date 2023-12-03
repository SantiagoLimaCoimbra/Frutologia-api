package xulep.co.frutologiaapi.DTOs.Frut;

import jakarta.persistence.Column;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

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
