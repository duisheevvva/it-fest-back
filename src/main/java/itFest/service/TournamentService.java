package itFest.service;

import itFest.dto.CyberSportRequest;
import itFest.dto.DesignRequest;
import itFest.dto.SimpleResponse;
import itFest.entities.TournamentParticipant;
import itFest.enums.ThematicSectionTournament;
import itFest.exception.BadRequestException;
import itFest.repository.TournamentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public SimpleResponse saveTournament(TournamentParticipant tournamentParticipant) {
        TournamentParticipant tournamentParticipant1 = new TournamentParticipant();
        tournamentParticipant1.setFirstName(tournamentParticipant.getFirstName());
        tournamentParticipant1.setLastName(tournamentParticipant.getLastName());
        tournamentParticipant1.setSurname(tournamentParticipant.getSurname());
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

    public SimpleResponse saveTournamentCyberSport(CyberSportRequest cyberSportRequest){
        TournamentParticipant tournamentParticipant1 = new TournamentParticipant();
        tournamentParticipant1.setFirstName(cyberSportRequest.getFirstName());
        tournamentParticipant1.setLastName(cyberSportRequest.getLastName());
        tournamentParticipant1.setSurname(cyberSportRequest.getSurname());
        tournamentParticipant1.setEmail(cyberSportRequest.getEmail());
        tournamentParticipant1.setCountry(cyberSportRequest.getCountry());
        tournamentParticipant1.setCity(cyberSportRequest.getCity());
        tournamentParticipant1.setThematicTournament(cyberSportRequest.getThematicTournament());
        tournamentParticipant1.setDateOfBirth(cyberSportRequest.getDateOfBirth());
        tournamentParticipant1.setPhoneNumber(cyberSportRequest.getPhoneNumber());
        if (cyberSportRequest.getThematicTournament() == ThematicSectionTournament.CYBER_SPORT) {
            tournamentParticipant1.setFormatParticipation(cyberSportRequest.getFormatParticipation());
            tournamentParticipant1.setDirection(cyberSportRequest.getDirection());
        }else {
            throw new BadRequestException("Invalid thematic tournament. Expected CYBER_SPORT!");
        }
        tournamentParticipant1.setCreatedDate(LocalDate.now());
        tournamentRepository.save(tournamentParticipant1);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!!")
                .build();
    }

    public SimpleResponse saveTournamentDesign(DesignRequest designRequest){
        TournamentParticipant tournamentParticipant1 = new TournamentParticipant();
        tournamentParticipant1.setFirstName(designRequest.getFirstName());
        tournamentParticipant1.setLastName(designRequest.getLastName());
        tournamentParticipant1.setSurname(designRequest.getSurname());
        tournamentParticipant1.setEmail(designRequest.getEmail());
        tournamentParticipant1.setCountry(designRequest.getCountry());
        tournamentParticipant1.setCity(designRequest.getCity());
        tournamentParticipant1.setThematicTournament(designRequest.getThematicTournament());
        tournamentParticipant1.setDateOfBirth(designRequest.getDateOfBirth());
        tournamentParticipant1.setPhoneNumber(designRequest.getPhoneNumber());
        if (designRequest.getThematicTournament() == ThematicSectionTournament.DESIGN_3D) {
            tournamentParticipant1.setDesignDirection(designRequest.getDesignDirection());
        }else {
            throw new BadRequestException("Invalid thematic tournament. Expected DESIGN_3D!");
        }
        tournamentParticipant1.setCreatedDate(LocalDate.now());
        tournamentRepository.save(tournamentParticipant1);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!!")
                .build();
    }


    public List<TournamentParticipant> findAll(){
        return tournamentRepository.findAll();
    }

    public List<TournamentParticipant> findByThematicSection( ThematicSectionTournament tournamentSection){
        return tournamentRepository.findByThematicSection(tournamentSection);
    }

}
