package am.itspace.authorbookrest.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveAuthorDto {

    private String name;
    private String surname;
    private Gender gender;
    private int age;
}

