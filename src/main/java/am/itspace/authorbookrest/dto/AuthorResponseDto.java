package am.itspace.authorbookrest.dto;

import am.itspace.authorbookrest.entity.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponseDto {

    private int id;
    private String firstName;
    private String surname;
    private Gender gender;
    private int age;
}
