package itFest.entities;

import itFest.enums.ThematicSectionPartner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "partners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "partner_gen")
    @SequenceGenerator(name = "partner_gen",sequenceName = "partner_seq",allocationSize = 1)
    private Long id;
    private String companyName;
    private String fullName;
    private String jobTitle;
    private String phoneNumber;
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private ThematicSectionPartner thematicPartner;

}
