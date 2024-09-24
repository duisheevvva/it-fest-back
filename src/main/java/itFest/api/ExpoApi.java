package itFest.api;

import itFest.dto.SimpleResponse;
import itFest.entities.ExpoParticipant;
import itFest.service.ExpoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/expo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class ExpoApi {
    private final ExpoService expoService;

    @PostMapping
    public SimpleResponse saveExpo(@RequestBody ExpoParticipant expoParticipant){
      return expoService.saveExpoParticipant(expoParticipant);
    }

}
