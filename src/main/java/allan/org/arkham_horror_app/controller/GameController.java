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
                ResponseEntity.notFound().build();
    }

    // === Encounter Decks ===

    @PostMapping("/encounterDeck/placeBottom/{neighborhood}")
    public ResponseEntity<String> placeEncounterCardOnBottom(@PathVariable String neighborhood) {
        try {
            gameService.placeEncounterCardOnBottom(neighborhood);
            return ResponseEntity.ok("Last drawn Encounter card placed on bottom of " + neighborhood + " deck.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // === Event Deck ===

    @PostMapping("/eventDeck/drawFromTop")
    public ResponseEntity<EventCard> drawEventCardFromTop() {
        return ResponseEntity.ok(gameService.drawEventCardFromTop());
    }

    @PostMapping("/eventDeck/drawFromBottom")
    public ResponseEntity<EventCard> drawEventCardFromBottom() {
        return ResponseEntity.ok(gameService.drawEventCardFromBottom());
    }

    // TODO: Change this to discard from Bottom. Top of Event Deck only discards when Gate Burst is drawn.
    @PostMapping("/eventDeck/discardFromTop")
    public ResponseEntity<String> discardEventCardFromTop() {
        try {
            gameService.discardEventCardFromTop();
            return ResponseEntity.ok("Event card discarded to Event deck discard pile.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // === Headline Deck ===

    @PostMapping("/headlineDeck/draw")
    public ResponseEntity<HeadlineCard> drawHeadlineCard() {
        return ResponseEntity.ok(gameService.drawHeadlineCard());
    }

    @PostMapping("/headlineDeck/placeBottom")
    public ResponseEntity<String> placeHeadlineCardOnBottom() {
        try {
            gameService.placeHeadlineCardOnBottom();
            return ResponseEntity.ok("Headline card placed on bottom of deck.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // === Monster Deck ===

    @PostMapping("/monsterDeck/draw")
    public ResponseEntity<MonsterCard> drawMonsterCard() {
        return ResponseEntity.ok(gameService.drawMonsterCard());
    }

    @PostMapping("/monsterDeck/placeTop")
    public ResponseEntity<String> returnMonsterCardToTop() {
        try {
            gameService.returnMonsterToTop();
            return ResponseEntity.ok("Monster card returned to top of Monster deck.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // === Mythos Cup ===

    @PostMapping("/mythosCup/draw")
    public ResponseEntity<MythosToken> drawMythosToken() {
        return ResponseEntity.ok(gameService.drawMythosToken());
    }

    @PostMapping("/mythosCup/discard")
    public ResponseEntity<String> discardMythosToken() {
        try {
            gameService.discardMythosToken();
            return ResponseEntity.ok("Mythos token discarded.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/mythosCup/reset")
    public ResponseEntity<String> resetMythosCup() {
        gameService.resetMythosCup();
        return ResponseEntity.ok("Mythos cup reset by reshuffling discard pile.");
    }

}