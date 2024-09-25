package itFest.dto;

import itFest.enums.HackathonDirection;
import itFest.enums.ThematicSectionTournament;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;

import java.time.LocalDate;
import java.util.List;

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
