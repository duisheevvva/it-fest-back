package itFest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "foodCort_participants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCortParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "foodCort_gen")
    @SequenceGenerator(name = "foodCort_gen",sequenceName = "foodCort_seq",allocationSize = 1)
    private Long id;
    private String brandName;
    private String fullName;
    private String jobTitle;
    private String companyActivity;
    private String email;
    private String country;
    private String phoneNumber;
    private String companyProduct;
    private LocalDate createdDate;
}
