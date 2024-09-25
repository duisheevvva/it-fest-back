package itFest.api;

import itFest.dto.CyberSportRequest;
import itFest.dto.DesignRequest;
import itFest.dto.SimpleResponse;
import itFest.entities.TournamentParticipant;
import itFest.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @PostMapping("cyberSport")
    public SimpleResponse saveCyberSport(@RequestBody CyberSportRequest cyberSportRequest){
        return tournamentService.saveTournamentCyberSport(cyberSportRequest);
    }

    @PostMapping("design")
    public SimpleResponse saveDesign(@RequestBody DesignRequest designRequest){
        return tournamentService.saveTournamentDesign(designRequest);
    }




//    @GetMapping("/export-participants")
//    public ResponseEntity<byte[]> exportParticipantsToExcel() {
//        try {
//            byte[] excelData = tournamentService.exportParticipantToExcel();
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Disposition", "attachment; filename=it fest members sheet.xlsx");
//
//            return new ResponseEntity<>(excelData, headers, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
