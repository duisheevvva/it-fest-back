package itFest.entities;

import itFest.enums.ThematicSectionTournament;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tournament_participants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TournamentParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tournament_gen")
    @SequenceGenerator(name = "tournament_gen",sequenceName = "tournament_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String surname;
    private LocalDate dateOfBirth;
    private String email;
    private String city;
    private String country;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private ThematicSectionTournament thematicTournament;
    private LocalDate createdDate;
}
