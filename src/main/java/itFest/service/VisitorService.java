package itFest.service;

import itFest.dto.SimpleResponse;
import itFest.entities.Visitor;
import itFest.exception.BadCredentialException;
import itFest.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public SimpleResponse saveVisitor(Visitor visitor) {
        try {
            Visitor visitor1 = new Visitor();
            visitor1.setName(visitor.getName());
            visitor1.setDateOfBirth(visitor.getDateOfBirth());
            visitor1.setCity(visitor.getCity());
            visitor1.setTypeOfActivity(visitor.getTypeOfActivity());
            visitor1.setPhoneNumber(visitor.getPhoneNumber());
            visitor1.setCreatedDate(LocalDate.now());
            visitorRepository.save(visitor1);

            return SimpleResponse
                    .builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Successfully saved!!")
                    .build();
        } catch (BadCredentialException e) {
            return SimpleResponse
                    .builder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("Failed to save visitor: " + e.getMessage())
                    .build();
        }
    }
}