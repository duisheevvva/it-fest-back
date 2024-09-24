package itFest.api;

import itFest.dto.SimpleResponse;
import itFest.entities.FoodCortParticipant;
import itFest.service.FoodCortService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/foodCort")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class FoodCortApi {
    private final FoodCortService foodCortService;

    @PostMapping
    public SimpleResponse saveFoodCort(@RequestBody FoodCortParticipant foodCortParticipant) {
        return foodCortService.saveFoodCort(foodCortParticipant);
    }

}
