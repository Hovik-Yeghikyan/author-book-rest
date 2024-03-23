package am.itspace.authorbookrest.dto;

import am.itspace.authorbookrest.entity.Author;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private int id;
    private String title;
    private String description;
    private double price;
    private double priceUSD;
    private AuthorResponseDto authorResponseDto;

}
