package itFest.service;

import itFest.dto.HackathonRequest;
import itFest.dto.SimpleResponse;
import itFest.entities.Hackathon;
import itFest.entities.HackathonTeam;
import itFest.exception.BadCredentialException;
import itFest.repository.HackathonRepository;
import itFest.repository.HackathonTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HackathonService {
    private final HackathonRepository hackathonRepository;
    private final HackathonTeamRepository hackathonTeamRepository;

    public SimpleResponse saveHackathon(HackathonRequest hackathonRequest){
        HackathonTeam hackathonTeam1 = new HackathonTeam();
        hackathonTeam1.setFullName(hackathonRequest.getFullName());
        hackathonTeam1.setEmail(hackathonRequest.getEmail());
        hackathonTeam1.setPosition(hackathonRequest.getPosition());
        hackathonTeam1.setPhoneNumber(hackathonRequest.getPhoneNumber());
        hackathonTeam1.setDateOfBirth(hackathonRequest.getDateOfBirth());
        hackathonTeamRepository.save(hackathonTeam1);
        Hackathon hackathon1 = new Hackathon();
        hackathon1.setTeamName(hackathonRequest.getTeamName());
        hackathon1.setCountry(hackathonRequest.getCountry());
        hackathon1.setCity(hackathonRequest.getCity());
        hackathon1.setThematicTournament(hackathonRequest.getThematicTournament());
        hackathon1.setHackathonDirection(hackathonRequest.getHackathonDirection());
        hackathon1.setHackathonTeamList(List.of(hackathonTeam1));
        hackathonRepository.save(hackathon1);

        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!!")
                .build();
    }


}
