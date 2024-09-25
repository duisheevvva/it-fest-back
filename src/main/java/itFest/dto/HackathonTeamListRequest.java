package itFest.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HackathonTeamListRequest {
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String position;
}
