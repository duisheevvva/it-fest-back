package itFest.api;

import itFest.dto.SimpleResponse;
import itFest.entities.Mobilography;
import itFest.service.MobilographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/mobilography")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class MobilographyApi {
    private final MobilographyService mobilographyService;

    @PostMapping
    public SimpleResponse saveMobilography(@RequestBody Mobilography mobilography){
        return mobilographyService.saveMobilography(mobilography);
    }
}
