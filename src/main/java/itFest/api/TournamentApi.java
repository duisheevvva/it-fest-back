package itFest.api;

import itFest.dto.SimpleResponse;
import itFest.entities.TournamentParticipant;
import itFest.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tournament")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class TournamentApi {
    private final TournamentService tournamentService;

    @PostMapping
    public SimpleResponse saveTournament(@RequestBody TournamentParticipant tournamentParticipant){
        return tournamentService.saveTournament(tournamentParticipant);
    }
}
