package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.ArchiveCard;
import allan.org.arkham_horror_app.service.ArchiveCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArchiveCardController {

    @Autowired
    private ArchiveCardService archiveCardService;

    @GetMapping("/")
    public String greet() {
        return "Home page!";
    }

    @GetMapping("/archiveCards")
    public ResponseEntity<List<ArchiveCard>> getArchiveCards() {
        return new ResponseEntity<>(archiveCardService.getAllArchiveCards(), HttpStatus.OK);
    }

}
