package itFest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "visitor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "visitor_gen")
    @SequenceGenerator(name = "visitor_gen",sequenceName = "visitor_seq")
    private Long id;
    private String name;
    private String city;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String typeOfActivity;
    private LocalDate createdDate;
}
