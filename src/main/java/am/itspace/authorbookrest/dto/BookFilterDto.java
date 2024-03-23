package am.itspace.authorbookrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookFilterDto {

    private String description;
    private String title;
    private Double minPrice;
    private Double maxPrice;
    private String orderBy;
    private String orderDirection;
    private int page;
    private int size;


}