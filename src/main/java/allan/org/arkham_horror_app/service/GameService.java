package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.*;
import allan.org.arkham_horror_app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    private Game game;

    @Autowired
    private ArchiveCardService archiveCardService;

    @Autowired
    private ArchiveCardRepository archiveCardRepository;

    @Autowired
    private EncounterCardService encounterCardService;

    @Autowired
    private EncounterCardRepository encounterCardRepository;

    @Autowired
    private EventCardRepository eventCardRepository;

    @Autowired
    private MonsterCardRepository monsterCardRepository;

    @Autowired
    private HeadlineCardRepository headlineCardRepository;

    @Autowired
    private MythosRepository mythosTokenRepository;

    public void initializeGame() {
        this.game = new Game();

        // Fetch initial Archive Cards for the Codex
        // TODO: Add specific Archive Cards to list, by number
//        List<ArchiveCard> initialCodexCards = archiveCardRepository.findByScenario("default-scenario");
//        game.getCodex().addAll(initialCodexCards);
        archiveCardService.addToCodex(1);
        archiveCardService.addToCodex(10);
        archiveCardService.addToCodex(11);

        // Fetch and initialize all the decks
        game.getDowntownDeck().getCards().addAll(encounterCardService.getEncounterCardsByNeighborhood("Downtown"));
        game.getEasttownDeck().getCards().addAll(encounterCardService.getEncounterCardsByNeighborhood("Easttown"));
        game.getRivertownDeck().getCards().addAll(encounterCardService.getEncounterCardsByNeighborhood("Rivertown"));
        game.getSouthsideDeck().getCards().addAll(encounterCardService.getEncounterCardsByNeighborhood("Southside"));
        game.getUptownDeck().getCards().addAll(encounterCardService.getEncounterCardsByNeighborhood("Uptown"));
        game.getStreetsDeck().getCards().addAll(encounterCardService.getEncounterCardsByNeighborhood("The Streets"));

        // Set up Headline Deck: retrieve all, shuffle, and select 13 for deck
        List<HeadlineCard> allHeadlineCards = headlineCardRepository.findAll();
        Collections.shuffle(allHeadlineCards);
        List<HeadlineCard> selectedHeadlines = allHeadlineCards.subList(0, Math.min(13, allHeadlineCards.size())); // Ensure it doesn't break if less than 13 exist
        game.getHeadlineDeck().addAll(selectedHeadlines);

        game.getEventDeck().addAll(eventCardRepository.findAll());
        game.getMonsterDeck().addAll(monsterCardRepository.findAll());
        game.getMythosCup().addAll(mythosTokenRepository.findAll());

        // Shuffle all decks by chaining .shuffle()
        game.getDowntownDeck().shuffle();
        game.getEasttownDeck().shuffle();
        game.getRivertownDeck().shuffle();
        game.getSouthsideDeck().shuffle();
        game.getUptownDeck().shuffle();
        game.getStreetsDeck().shuffle();

        game.getEventDeck().shuffle();
        game.getMonsterDeck().shuffle();
        game.getHeadlineDeck().shuffle();
        game.getMythosCup().shuffle();
        System.out.println("Game initialized with all decks loaded.");
    }

    public Game getCurrentGame() {
        return game;
    }
}
