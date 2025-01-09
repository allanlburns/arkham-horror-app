package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.ArchiveCard;
import allan.org.arkham_horror_app.service.ArchiveCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/archiveCard/{number}")
    public ResponseEntity<ArchiveCard> getArchiveCard(@PathVariable int number) {
        return new ResponseEntity<ArchiveCard>(archiveCardService.getArchiveCardByNum(number), HttpStatus.OK);
    }

    // Methods for Codex
    @PostMapping("/codex/cards/{cardNumber}")
    public ResponseEntity<Void> addToCodex(@PathVariable int cardNumber) {
        archiveCardService.addToCodex(cardNumber);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/codex/cards/{cardNumber}")
    public ResponseEntity<Void> removeFromCodex(@PathVariable int cardNumber) {
        archiveCardService.removeFromCodex(cardNumber);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/codex/cards")
    public ResponseEntity<List<ArchiveCard>> getCodexCards() {
        return ResponseEntity.ok(archiveCardService.getCodexCards());
    }

}
