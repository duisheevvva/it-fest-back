package itFest.dto;

import itFest.enums.HackathonDirection;
import itFest.enums.ThematicSectionTournament;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HackathonRequest {
    private String teamName;
    private String country;
    private String city;
    @Enumerated(EnumType.STRING)
    private ThematicSectionTournament thematicTournament;
    @Enumerated(EnumType.STRING)
    private HackathonDirection hackathonDirection;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String position;
}
