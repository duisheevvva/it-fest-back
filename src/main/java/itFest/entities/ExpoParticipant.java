package itFest.entities;

import itFest.enums.ThematicSectionExpo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "expo_participants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpoParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "expo_gen")
    @SequenceGenerator(name = "expo_gen",sequenceName = "expo_seq")
    private Long id;
    private String brandName;
    private String fullName;
    private String jobTitle;
    private String companyActivity;
    private String email;
    private String country;
    private String phoneNumber;
    private String companyProduct;
    @Enumerated(EnumType.STRING)
    private ThematicSectionExpo thematicExpo;
    private LocalDate createdDate;

}
