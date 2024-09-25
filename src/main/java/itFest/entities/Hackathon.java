package itFest.entities;

import itFest.enums.HackathonDirection;
import itFest.enums.ThematicSectionTournament;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "hackathons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hackathon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hackathon_gen")
    @SequenceGenerator(name = "hackathon_gen",sequenceName = "hackathon_seq",allocationSize = 1,initialValue = 5)
    private Long id;
    private String teamName;
    private String country;
    private String city;
    @Enumerated(EnumType.STRING)
    private ThematicSectionTournament thematicTournament;
    @Enumerated(EnumType.STRING)
    private HackathonDirection hackathonDirection;
//    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
//    private List<HackathonTeam> hackathonTeamList;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String position;

}
