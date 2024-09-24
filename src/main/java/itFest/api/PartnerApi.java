package itFest.api;

import itFest.dto.SimpleResponse;
import itFest.entities.Partner;
import itFest.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/partner")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class PartnerApi {

    private final PartnerService partnerService;

    @PostMapping
    public SimpleResponse savePartner(@RequestBody Partner partner) {
        return partnerService.savedPartner(partner);
    }
}
