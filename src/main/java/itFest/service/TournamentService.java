package itFest.service;

import itFest.dto.SimpleResponse;
import itFest.entities.TournamentParticipant;
import itFest.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public SimpleResponse saveTournament(TournamentParticipant tournamentParticipant) {
        TournamentParticipant tournamentParticipant1 = new TournamentParticipant();
        tournamentParticipant1.setFirstName(tournamentParticipant.getFirstName());
        tournamentParticipant1.setLastName(tournamentParticipant.getLastName());
        tournamentParticipant1.setSurname(tournamentParticipant1.getSurname());
        tournamentParticipant1.setEmail(tournamentParticipant.getEmail());
        tournamentParticipant1.setCountry(tournamentParticipant.getCountry());
        tournamentParticipant1.setCity(tournamentParticipant.getCity());
        tournamentParticipant1.setThematicTournament(tournamentParticipant.getThematicTournament());
        tournamentParticipant1.setDateOfBirth(tournamentParticipant.getDateOfBirth());
        tournamentParticipant1.setPhoneNumber(tournamentParticipant.getPhoneNumber());
        tournamentParticipant1.setCreatedDate(LocalDate.now());
        tournamentRepository.save(tournamentParticipant1);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!!")
                .build();
    }
}
