package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.HeadlineCard;
import allan.org.arkham_horror_app.service.HeadlineCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeadlineCardController {

    @Autowired
    private HeadlineCardService headlineCardService;

    @GetMapping("/headlineCards")
    public ResponseEntity<List<HeadlineCard>> getHeadlineCards() {
        return new ResponseEntity<>(headlineCardService.getHeadlineCards(), HttpStatus.OK);
    }

    @GetMapping("/headlineCard/{number}")
    public ResponseEntity<HeadlineCard> getHeadlineCard(@PathVariable int number) {
        return new ResponseEntity<>(headlineCardService.getHeadlineCard(number), HttpStatus.OK);
    }
}
