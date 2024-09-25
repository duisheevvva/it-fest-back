package itFest.api;

import itFest.dto.SimpleResponse;
import itFest.entities.Mobilography;
import itFest.service.MobilographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mobilography")
@RequiredArgsConstructor
public class MobilographyApi {
    private final MobilographyService mobilographyService;

    @PostMapping
    public SimpleResponse saveMobilography(@RequestBody Mobilography mobilography){
        return mobilographyService.saveMobilography(mobilography);
    }
}
