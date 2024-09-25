package itFest.entities;

import itFest.enums.HackathonDirection;
import itFest.enums.ThematicSectionTournament;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @SequenceGenerator(name = "hackathon_gen",sequenceName = "hackathon_seq",allocationSize = 1)
    private Long id;
    private String teamName;
    private String country;
    private String city;
    @Enumerated(EnumType.STRING)
    private ThematicSectionTournament thematicTournament;
    @Enumerated(EnumType.STRING)
    private HackathonDirection hackathonDirection;
    @ManyToMany
    private List<HackathonTeam> hackathonTeamList;

}
