package itFest.service;

import itFest.dto.SimpleResponse;
import itFest.entities.Mobilography;
import itFest.repository.MobilographyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MobilographyService {
    private final MobilographyRepository mobilographyRepository;

    public SimpleResponse saveMobilography(Mobilography mobilography){
        Mobilography mobilography1 = new Mobilography();
        mobilography1.setFirstName(mobilography.getFirstName());
        mobilography1.setLastName(mobilography.getLastName());
        mobilography1.setPhoneNumber(mobilography.getPhoneNumber());
        mobilography1.setLinkVideo(mobilography.getLinkVideo());
        mobilographyRepository.save(mobilography1);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved")
                .build();
    }

    public List<Mobilography> findAll(){
        return mobilographyRepository.findAll();
    }
}
