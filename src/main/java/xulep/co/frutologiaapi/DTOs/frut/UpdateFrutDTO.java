package xulep.co.frutologiaapi.DTOs.frut;

import lombok.Data;

@Data
public class UpdateFrutDTO {

    private Long id;
    private String name;
    private String family;
    private String order;
    private String genus;

}
