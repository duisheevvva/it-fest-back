package itFest.service;

import itFest.dto.SimpleResponse;
import itFest.entities.ExpoParticipant;
import itFest.repository.ExpoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpoService {
    private final ExpoRepository expoRepository;

    public SimpleResponse saveExpoParticipant(ExpoParticipant expoParticipant) {
        ExpoParticipant expoParticipant1 = new ExpoParticipant();
        expoParticipant1.setBrandName(expoParticipant.getBrandName());
        expoParticipant1.setFullName(expoParticipant1.getFullName());
        expoParticipant1.setEmail(expoParticipant.getEmail());
        expoParticipant1.setCountry(expoParticipant.getCountry());
        expoParticipant1.setJobTitle(expoParticipant.getJobTitle());
        expoParticipant1.setCompanyActivity(expoParticipant.getCompanyActivity());
        expoParticipant1.setCompanyProduct(expoParticipant.getCompanyProduct());
        expoParticipant1.setPhoneNumber(expoParticipant.getPhoneNumber());
        expoParticipant1.setThematicExpo(expoParticipant.getThematicExpo());
        expoParticipant1.setCreatedDate(LocalDate.now());
        expoRepository.save(expoParticipant);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!")
                .build();
    }
}
