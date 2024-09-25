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



//    public byte[] exportParticipantToExcel() throws IOException {
//        log.info("Экспорт данных участника турнира в Excel начат.");
//
//        List<TournamentParticipant> participants = findAll();
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Participants");
//
//        // Заголовки таблицы
//        Row headerRow = sheet.createRow(0);
//        String[] headers = {"Имя", "Фамилия", "Отчество", "Email", "Страна", "Город", "Тематика турнира", "Дата рождения", "Телефон", "Дата создания"};
//
//        for (int i = 0; i < headers.length; i++) {
//            Cell headerCell = headerRow.createCell(i);
//            headerCell.setCellValue(headers[i]);
//            headerCell.setCellStyle(createHeaderCellStyle(workbook));
//        }
//
//        int rowNum = 1;
//        for (TournamentParticipant participant : participants) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(participant.getFirstName());
//            row.createCell(1).setCellValue(participant.getLastName());
//            row.createCell(2).setCellValue(participant.getSurname());
//            row.createCell(3).setCellValue(participant.getEmail());
//            row.createCell(4).setCellValue(participant.getCountry());
//            row.createCell(5).setCellValue(participant.getCity());
//            row.createCell(6).setCellValue(participant.getThematicTournament().ordinal());
//            row.createCell(7).setCellValue(participant.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            row.createCell(8).setCellValue(participant.getPhoneNumber());
//            row.createCell(9).setCellValue(participant.getCreatedDate().toString());
//        }
//
//        // Автоматическое изменение ширины колонок
//        for (int i = 0; i < headers.length; i++) {
//            sheet.autoSizeColumn(i);
//        }
//
//        // Запись данных в байтовый массив
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        workbook.write(bos);
//        workbook.close();
//
//        log.info("Экспорт данных участника турнира в Excel завершен.");
//        return bos.toByteArray();
//    }
//
//    private CellStyle createHeaderCellStyle(Workbook workbook) {
//        CellStyle cellStyle = workbook.createCellStyle();
//        Font font = workbook.createFont();
//        font.setBold(true);
//        cellStyle.setFont(font);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        return cellStyle;
//    }

}
