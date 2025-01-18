package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.EncounterCard;
import allan.org.arkham_horror_app.service.EncounterCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EncounterController {

    @Autowired
    private EncounterCardService encounterCardService;

    @GetMapping("/encounterCards")
    public ResponseEntity<List<EncounterCard>> getEncounterCards() {
        return new ResponseEntity<>(encounterCardService.getAllEncounterCards(), HttpStatus.OK);
    }

    @GetMapping("/encounterCard/{neighborhood}")
    public ResponseEntity<List<EncounterCard>> getArchiveCard(@PathVariable String neighborhood) {
        return new ResponseEntity<>(encounterCardService.getEncounterCardsByNeighborhood(neighborhood), HttpStatus.OK);
    }
}
