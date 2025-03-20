package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.*;
import allan.org.arkham_horror_app.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/state")
    public Game getGameState() {
        return gameService.getCurrentGame();
    }

//    TODO: Need to define Codex class and initialize Codex in Archive. Then work on Archive Card/Codex methods
//    Same in GameService

//    @PostMapping("/codex/add/{archiveCardId}")
//    public ResponseEntity<ArchiveCard> addToCodex(@PathVariable int archiveCardNumber) {
//        return new ResponseEntity<>(gameService.addToCodex(archiveCardNumber), HttpStatus.OK);
//    }

    @PostMapping("/encounterDeck/draw/{neighborhood}")
    public ResponseEntity<Card> drawEncounterCard(@PathVariable String neighborhood) {
        Card drawnCard = gameService.drawEncounterCard(neighborhood);
        return drawnCard != null ? ResponseEntity.ok(drawnCard) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/encounterDeck/placeBottom/{neighborhood}/{cardId}")
    public ResponseEntity<String> placeEncounterCardOnBottom(@PathVariable String neighborhood, @PathVariable Long cardId) {

        Card card = gameService.getCardById(cardId);
        if (card == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card with ID " + cardId + " not found.");
        }

        gameService.placeEncounterCardOnBottom(neighborhood, card);
        return ResponseEntity.ok("Card " + cardId + " placed at bottom of " + neighborhood + " Encounter Deck.");
    }

}