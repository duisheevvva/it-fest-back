package itFest.api;

import itFest.dto.HackathonRequest;
import itFest.dto.SimpleResponse;
import itFest.service.HackathonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/hackathon")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class HackathonApi {

    private final HackathonService hackathonService;

    @PostMapping
    public SimpleResponse saveHackathon(@RequestBody HackathonRequest hackathonRequest){
        return  hackathonService.saveHackathon(hackathonRequest);
    }

}
