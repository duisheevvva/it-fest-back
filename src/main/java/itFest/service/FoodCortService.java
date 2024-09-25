package itFest.service;

import itFest.dto.SimpleResponse;
import itFest.entities.FoodCortParticipant;
import itFest.repository.FoodCortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class FoodCortService {

    private final FoodCortRepository foodCortRepository;

    public SimpleResponse saveFoodCort(FoodCortParticipant foodCortParticipant) {
        FoodCortParticipant foodCortParticipant1 = new FoodCortParticipant();
        foodCortParticipant1.setBrandName(foodCortParticipant.getBrandName());
        foodCortParticipant1.setFullName(foodCortParticipant.getFullName());
        foodCortParticipant1.setCountry(foodCortParticipant.getCountry());
        foodCortParticipant1.setEmail(foodCortParticipant.getEmail());
        foodCortParticipant1.setCompanyProduct(foodCortParticipant.getCompanyProduct());
        foodCortParticipant1.setCompanyActivity(foodCortParticipant.getCompanyActivity());
        foodCortParticipant1.setJobTitle(foodCortParticipant.getJobTitle());
        foodCortParticipant1.setPhoneNumber(foodCortParticipant.getPhoneNumber());
        foodCortParticipant1.setCreatedDate(LocalDate.now());
        foodCortRepository.save(foodCortParticipant1);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!!!")
                .build();
    }

    public List<FoodCortParticipant> findAll(){
        return foodCortRepository.findAll();
    }
}
