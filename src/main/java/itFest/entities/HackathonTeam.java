package itFest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "hackathons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HackathonTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hackathonTeam_gen")
    @SequenceGenerator(name = "hackathonTeam_gen", sequenceName = "hackathonTeam_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String position;
}
