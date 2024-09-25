package itFest.service;

import itFest.dto.HackathonRequest;
import itFest.dto.HackathonTeamListRequest;
import itFest.dto.SimpleResponse;
import itFest.entities.Hackathon;
import itFest.entities.HackathonTeam;
import itFest.enums.HackathonDirection;
import itFest.enums.ThematicSectionTournament;
import itFest.exception.BadCredentialException;
import itFest.repository.HackathonRepository;
import itFest.repository.HackathonTeamRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HackathonService {
    private final HackathonRepository hackathonRepository;
    private final HackathonTeamRepository hackathonTeamRepository;


    public SimpleResponse saveHackathon(HackathonRequest hackathonRequest) {
        Hackathon hackathon1 = new Hackathon();
        hackathon1.setTeamName(hackathonRequest.getTeamName());
        hackathon1.setCountry(hackathonRequest.getCountry());
        hackathon1.setCity(hackathonRequest.getCity());
        hackathon1.setThematicTournament(hackathonRequest.getThematicTournament());
        hackathon1.setHackathonDirection(hackathonRequest.getHackathonDirection());
        hackathon1.setFullName(hackathonRequest.getFullName());
        hackathon1.setDateOfBirth(hackathonRequest.getDateOfBirth());
        hackathon1.setEmail(hackathonRequest.getEmail());
        hackathon1.setPhoneNumber(hackathonRequest.getPhoneNumber());
        hackathon1.setPosition(hackathonRequest.getPosition());
        hackathonRepository.save(hackathon1);


        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!!")
                .build();

    }




}
