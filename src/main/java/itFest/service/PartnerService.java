package itFest.service;

import itFest.dto.SimpleResponse;
import itFest.entities.Partner;
import itFest.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class PartnerService {

    private final PartnerRepository partnerRepository;

    public SimpleResponse savedPartner(Partner partner) {
        Partner partner1 = new Partner();
        partner1.setFullName(partner.getFullName());
        partner1.setCompanyName(partner.getCompanyName());
        partner1.setJobTitle(partner.getJobTitle());
        partner1.setPhoneNumber(partner.getPhoneNumber());
        partner1.setThematicPartner(partner.getThematicPartner());
        partner1.setCreatedDate(LocalDate.now());
        partnerRepository.save(partner1);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved!!")
                .build();
    }
}
