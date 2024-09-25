package itFest.service;

import itFest.dto.HackathonRequest;
import itFest.dto.HackathonTeamListRequest;
import itFest.dto.SimpleResponse;
import itFest.entities.Hackathon;
import itFest.entities.HackathonTeam;
import itFest.repository.HackathonRepository;
import itFest.repository.HackathonTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HackathonService {

    private final HackathonRepository hackathonRepository;
    private final HackathonTeamRepository hackathonTeamRepository;

    public SimpleResponse saveHackathon(HackathonRequest hackathonRequest) {
        Hackathon hackathon = new Hackathon();
        hackathon.setTeamName(hackathonRequest.getTeamName());
        hackathon.setCountry(hackathonRequest.getCountry());
        hackathon.setCity(hackathonRequest.getCity());
        hackathon.setThematicTournament(hackathonRequest.getThematicTournament());
        hackathon.setHackathonDirection(hackathonRequest.getHackathonDirection());

        List<HackathonTeam> hackathonTeams = new ArrayList<>();
        for (HackathonTeamListRequest teamMember : hackathonRequest.getHackathonTeams()) {
            HackathonTeam hackathonTeam = new HackathonTeam();
            hackathonTeam.setFullName(teamMember.getFullName());
            hackathonTeam.setEmail(teamMember.getEmail());
            hackathonTeam.setDateOfBirth(teamMember.getDateOfBirth());
            hackathonTeam.setPhoneNumber(teamMember.getPhoneNumber());
            hackathonTeam.setPosition(teamMember.getPosition());
            hackathonTeam.setHackathon(hackathon);
            hackathonTeams.add(hackathonTeam);
        }

        hackathon.setHackathonTeam(hackathonTeams);
        hackathonRepository.save(hackathon);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!")
                .build();
    }

    public List<Hackathon> findAll(){
        return hackathonRepository.findAll();
    }

}