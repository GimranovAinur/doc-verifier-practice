package andersen.practice.docverifier.controller;

import andersen.practice.docverifier.domain.document.Field;
import andersen.practice.docverifier.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/earliest_unverified_field")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class FieldController {

    private final FieldService fieldService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Field getEarliestField() {
        return fieldService.getEarliestUnverifiedField();
    }

}
