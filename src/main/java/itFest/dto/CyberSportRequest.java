package itFest.dto;

import itFest.enums.Direction;
import itFest.enums.FormatParticipation;
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
public class CyberSportRequest {
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
    @Enumerated(EnumType.STRING)
    private FormatParticipation formatParticipation;
    @Enumerated(EnumType.STRING)
    private Direction direction;
}
