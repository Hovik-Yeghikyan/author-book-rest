package am.itspace.authorbookrest.entity;

import am.itspace.authorbookrest.dto.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private LocalDate createdDate;
}
