package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.EventCard;
import allan.org.arkham_horror_app.service.EventCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventCardController {

    @Autowired
    private EventCardService eventCardService;

    @GetMapping("/eventCards")
    public ResponseEntity<List<EventCard>> getAllEventCards() {
        return new ResponseEntity<>(eventCardService.getAllEventCards(), HttpStatus.OK);
    }

    @GetMapping("/eventCards/{scenario}")
    public ResponseEntity<List<EventCard>> getEventCardsByScenario(@PathVariable String scenario) {
        return new ResponseEntity<>(eventCardService.getEventCardsByScenario(scenario), HttpStatus.OK);
    }
}
