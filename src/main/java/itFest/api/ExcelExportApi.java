package itFest.api;

import itFest.service.ExcelExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("api/expo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class ExcelExportApi {
    private final ExcelExportService excelExportService;
    @GetMapping("/export/excel")
    public ResponseEntity<byte[]> exportToExcel() {
        try {
            ByteArrayOutputStream outputStream = excelExportService.exportDataToExcel();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=it fest members sheet.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(outputStream.toByteArray());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error generating Excel file".getBytes());
        }
    }
}
