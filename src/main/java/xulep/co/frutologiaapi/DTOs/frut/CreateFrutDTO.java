package xulep.co.frutologiaapi.DTOs.frut;

import lombok.Data;

@Data
public class CreateFrutDTO {

    //@NotBlank
    private String name;
    private String family;
    private String order;
    private String genus;
}
