package itFest.api;

import itFest.dto.SimpleResponse;
import itFest.entities.Visitor;
import itFest.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/visitor")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class VisitorApi {
    private final VisitorService visitorService;

    @PostMapping
    public SimpleResponse saveVisitor(@RequestBody Visitor visitor){
        return visitorService.saveVisitor(visitor);
    }

}
