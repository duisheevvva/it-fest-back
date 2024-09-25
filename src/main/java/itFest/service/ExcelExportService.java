package itFest.service;

import itFest.entities.*;
import itFest.enums.ThematicSectionTournament;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExcelExportService {
    private final ExpoService expoService;
    private final FoodCortService foodCortService;
    private final HackathonService hackathonService;
    private final PartnerService partnerService;
    private final TournamentService tournamentService;
    private final VisitorService visitorService;


    public ByteArrayOutputStream exportDataToExcel() throws IOException {

        Workbook workbook = new XSSFWorkbook();

        // Экспорт данных из таблицы участников выставки
        Sheet expoSheet = workbook.createSheet("Expo ");
        writeExpoHeader(expoSheet);
        List<ExpoParticipant> expoParticipants = expoService.findAll();
        writeExpoData(expoSheet, expoParticipants);
        autoSizeColumns(expoSheet, 10);


        // Экспорт данных из таблицы участников фудкорта
        Sheet foodCortSheet = workbook.createSheet("Food Cort");
        writeFoodCortHeader(foodCortSheet);
        List<FoodCortParticipant> foodCortParticipants = foodCortService.findAll();
        writeFoodCortData(foodCortSheet, foodCortParticipants);
        autoSizeColumns(foodCortSheet, 9);

        // Экспорт данных из таблицы хакатонов
        Sheet hackathonSheet = workbook.createSheet("Hackathons");
        writeHackathonHeader(hackathonSheet);
        List<Hackathon> hackathons = hackathonService.findAll();
        writeHackathonData(hackathonSheet, hackathons);
        autoSizeColumns(hackathonSheet, 11);

        // Экспорт данных из таблицы партнеров
        Sheet partnerSheet = workbook.createSheet("Partners");
        writePartnerHeader(partnerSheet);
        List<Partner> partners = partnerService.findAll();
        writePartnerData(partnerSheet, partners);
        autoSizeColumns(partnerSheet, 6);

        // Экспорт данных из таблицы посетителей
        Sheet visitorSheet = workbook.createSheet("Visitors");
        writeVisitorHeader(visitorSheet);
        List<Visitor> visitors = visitorService.findAll();
        writeVisitorData(visitorSheet, visitors);
        autoSizeColumns(visitorSheet, 6);

        // Экспорт данных из таблицы турниров
        Sheet tournamentSheet = workbook.createSheet("Tournaments");
        writeTournamentHeader(tournamentSheet);
        List<TournamentParticipant> tournaments = tournamentService.findAll();
        writeTournamentData(tournamentSheet, tournaments);
        autoSizeColumns(tournamentSheet, 13);

        // Экспорт данных для DESIGN_3D
        Sheet designSheet = workbook.createSheet("Design 3D");
        writeTournamentHeader(designSheet);
        List<TournamentParticipant> designParticipants = tournamentService.findByThematicSection(ThematicSectionTournament.DESIGN_3D);
        writeTournamentData(designSheet, designParticipants);
        autoSizeColumns(tournamentSheet, 13);

        // Экспорт данных для CYBER_SPORT
        Sheet cyberSportSheet = workbook.createSheet("Cyber Sport");
        writeTournamentHeader(cyberSportSheet);
        List<TournamentParticipant> cyberSportParticipants = tournamentService.findByThematicSection(ThematicSectionTournament.CYBER_SPORT);
        writeTournamentData(cyberSportSheet, cyberSportParticipants);
        autoSizeColumns(tournamentSheet, 13);

        // Запись данных в поток
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream;
    }

    private void autoSizeColumns(Sheet sheet, int numberOfColumns) {
        for (int i = 0; i < numberOfColumns; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private CellStyle createHeaderCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // Установка фона заголовка
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Установка жирного шрифта
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        return style;
    }


    private void setCellColor(Cell cell, IndexedColors color) {
        CellStyle style = cell.getSheet().getWorkbook().createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
    }


    // Заголовки для участников выставки
    private void writeExpoHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        sheet.setColumnWidth(0, 20 * 256); // Установка ширины первого столбца в 20 символов
        sheet.setColumnWidth(1, 30 * 256); // Ширина для второго столбца

        CellStyle headerStyle = createHeaderCellStyle(sheet.getWorkbook());
        header.createCell(0).setCellValue("Brand Name");
        header.getCell(0).setCellStyle(headerStyle);
        header.createCell(1).setCellValue("Full Name");
        header.getCell(1).setCellStyle(headerStyle);
        header.createCell(2).setCellValue("Email");
        header.getCell(2).setCellStyle(headerStyle);

        header.createCell(3).setCellValue("Country");
        header.getCell(3).setCellStyle(headerStyle);
        // Добавьте другие заголовки, если нужно
    }

    // Запись данных участников выставки
    private void writeExpoData(Sheet sheet, List<ExpoParticipant> expoParticipants) {
        int rowNum = 1;
        for (ExpoParticipant participant : expoParticipants) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(participant.getBrandName());
            row.createCell(1).setCellValue(participant.getFullName());
            row.createCell(2).setCellValue(participant.getEmail());
            row.createCell(3).setCellValue(participant.getCountry());
            // Добавьте другие поля, если нужно

        }
    }

    // Заголовки для участников фудкорта
    private void writeFoodCortHeader(Sheet sheet) {
        Row header = sheet.createRow(0);

        sheet.setColumnWidth(0, 20 * 256); // Установка ширины первого столбца в 20 символов
        sheet.setColumnWidth(1, 30 * 256); // Ширина для второго столбца
        CellStyle headerStyle = createHeaderCellStyle(sheet.getWorkbook());

        header.createCell(0).setCellValue("Brand Name");
        header.getCell(0).setCellStyle(headerStyle);

        header.createCell(1).setCellValue("Full Name");
        header.getCell(1).setCellStyle(headerStyle);

        header.createCell(2).setCellValue("Email");
        header.getCell(2).setCellStyle(headerStyle);

        header.createCell(3).setCellValue("Country");
        header.getCell(3).setCellStyle(headerStyle);

        header.createCell(4).setCellValue("Company Product");
        header.getCell(4).setCellStyle(headerStyle);

        header.createCell(5).setCellValue("Company Activity");
        header.getCell(5).setCellStyle(headerStyle);

        header.createCell(6).setCellValue("Job Title");
        header.getCell(6).setCellStyle(headerStyle);

        header.createCell(7).setCellValue("Phone Number");
        header.getCell(7).setCellStyle(headerStyle);

    }

    // Запись данных участников фудкорта
    private void writeFoodCortData(Sheet sheet, List<FoodCortParticipant> foodCortParticipants) {
        int rowNum = 1;
        for (FoodCortParticipant participant : foodCortParticipants) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(participant.getBrandName());
            row.createCell(1).setCellValue(participant.getFullName());
            row.createCell(2).setCellValue(participant.getEmail());
            row.createCell(3).setCellValue(participant.getCountry());
            row.createCell(4).setCellValue(participant.getCompanyProduct());
            row.createCell(5).setCellValue(participant.getCompanyActivity());
            row.createCell(6).setCellValue(participant.getJobTitle());
            row.createCell(7).setCellValue(participant.getPhoneNumber());
        }
    }

    // Заголовки для хакатонов
    private void writeHackathonHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        sheet.setColumnWidth(0, 20 * 256); // Установка ширины первого столбца в 20 символов
        sheet.setColumnWidth(1, 30 * 256); // Ширина для второго столбца
        CellStyle headerStyle = createHeaderCellStyle(sheet.getWorkbook());

        header.createCell(0).setCellValue("Team Name");
        header.getCell(0).setCellStyle(headerStyle);

        header.createCell(1).setCellValue("Country");
        header.getCell(1).setCellStyle(headerStyle);

        header.createCell(2).setCellValue("City");
        header.getCell(2).setCellStyle(headerStyle);

        header.createCell(3).setCellValue("Thematic Tournament");
        header.getCell(3).setCellStyle(headerStyle);

        header.createCell(4).setCellValue("Hackathon Direction");
        header.getCell(4).setCellStyle(headerStyle);

        // Добавьте другие заголовки, если нужно
    }

    // Запись данных хакатонов
    private void writeHackathonData(Sheet sheet, List<Hackathon> hackathons) {
        int rowNum = 1;
        for (Hackathon hackathon : hackathons) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(hackathon.getTeamName());
            row.createCell(1).setCellValue(hackathon.getCountry());
            row.createCell(2).setCellValue(hackathon.getCity());
            row.createCell(3).setCellValue(hackathon.getThematicTournament().toString());
            row.createCell(4).setCellValue(hackathon.getHackathonDirection().toString());
        }
    }

    // Заголовки для партнеров
    private void writePartnerHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        sheet.setColumnWidth(0, 20 * 256); // Установка ширины первого столбца в 20 символов
        sheet.setColumnWidth(1, 30 * 256); // Ширина для второго столбца
        CellStyle headerStyle = createHeaderCellStyle(sheet.getWorkbook());

        header.createCell(0).setCellValue("Full Name");
        header.getCell(0).setCellStyle(headerStyle);

        header.createCell(1).setCellValue("Company Name");
        header.getCell(1).setCellStyle(headerStyle);

        header.createCell(2).setCellValue("Job Title");
        header.getCell(2).setCellStyle(headerStyle);

        header.createCell(3).setCellValue("Phone Number");
        header.getCell(3).setCellStyle(headerStyle);

        header.createCell(4).setCellValue("Thematic Partner");
        header.getCell(4).setCellStyle(headerStyle);

        // Добавьте другие заголовки, если нужно
    }

    // Запись данных партнеров
    private void writePartnerData(Sheet sheet, List<Partner> partners) {
        int rowNum = 1;
        for (Partner partner : partners) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(partner.getFullName());
            row.createCell(1).setCellValue(partner.getCompanyName());
            row.createCell(2).setCellValue(partner.getJobTitle());
            row.createCell(3).setCellValue(partner.getPhoneNumber());
            row.createCell(4).setCellValue(partner.getThematicPartner().toString());
        }
    }

    // Заголовки для посетителей
    private void writeVisitorHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        sheet.setColumnWidth(0, 20 * 256); // Установка ширины первого столбца в 20 символов
        sheet.setColumnWidth(1, 30 * 256); // Ширина для второго столбца
        CellStyle headerStyle = createHeaderCellStyle(sheet.getWorkbook());

        header.createCell(0).setCellValue("Name");
        header.getCell(0).setCellStyle(headerStyle);

        header.createCell(1).setCellValue("Date of Birth");
        header.getCell(1).setCellStyle(headerStyle);

        header.createCell(2).setCellValue("City");
        header.getCell(2).setCellStyle(headerStyle);

        header.createCell(3).setCellValue("Type of Activity");
        header.getCell(3).setCellStyle(headerStyle);

        header.createCell(4).setCellValue("Phone Number");
        header.getCell(4).setCellStyle(headerStyle);

    }

    // Запись данных посетителей
    private void writeVisitorData(Sheet sheet, List<Visitor> visitors) {
        int rowNum = 1;
        for (Visitor visitor : visitors) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(visitor.getName());
            row.createCell(1).setCellValue(visitor.getDateOfBirth() != null ? visitor.getDateOfBirth().toString() : "");
            row.createCell(2).setCellValue(visitor.getCity());
            row.createCell(3).setCellValue(visitor.getTypeOfActivity());
            row.createCell(4).setCellValue(visitor.getPhoneNumber());
        }
    }

    // Заголовки для турниров
    private void writeTournamentHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        sheet.setColumnWidth(0, 20 * 256); // Установка ширины первого столбца в 20 символов
        sheet.setColumnWidth(1, 30 * 256); // Ширина для второго столбца
        CellStyle headerStyle = createHeaderCellStyle(sheet.getWorkbook());

        header.createCell(0).setCellValue("First Name");
        header.getCell(0).setCellStyle(headerStyle);

        header.createCell(1).setCellValue("Last Name");
        header.getCell(1).setCellStyle(headerStyle);

        header.createCell(2).setCellValue("Surname");
        header.getCell(2).setCellStyle(headerStyle);

        header.createCell(3).setCellValue("Email");
        header.getCell(3).setCellStyle(headerStyle);

        header.createCell(4).setCellValue("Country");
        header.getCell(4).setCellStyle(headerStyle);

        header.createCell(5).setCellValue("City");
        header.getCell(5).setCellStyle(headerStyle);

        header.createCell(6).setCellValue("Thematic Tournament");
        header.getCell(6).setCellStyle(headerStyle);

        header.createCell(7).setCellValue("Date of Birth");
        header.getCell(7).setCellStyle(headerStyle);

        header.createCell(8).setCellValue("Phone Number");
        header.getCell(8).setCellStyle(headerStyle);

    }

    // Запись данных турниров
    private void writeTournamentData(Sheet sheet, List<TournamentParticipant> tournaments) {
        int rowNum = 1;
        for (TournamentParticipant tournament : tournaments) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(tournament.getFirstName());
            row.createCell(1).setCellValue(tournament.getLastName());
            row.createCell(2).setCellValue(tournament.getSurname());
            row.createCell(3).setCellValue(tournament.getEmail());
            row.createCell(4).setCellValue(tournament.getCountry());
            row.createCell(5).setCellValue(tournament.getCity());
            row.createCell(6).setCellValue(tournament.getThematicTournament().toString());
            row.createCell(7).setCellValue(tournament.getDateOfBirth() != null ? tournament.getDateOfBirth().toString() : "");
            row.createCell(8).setCellValue(tournament.getPhoneNumber());
        }
    }
}

