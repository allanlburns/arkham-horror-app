package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.ArchiveCard;
import allan.org.arkham_horror_app.model.Game;
import allan.org.arkham_horror_app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private Game game;

    @Autowired
    private ArchiveCardService archiveCardService;

    @Autowired
    private ArchiveCardRepository archiveCardRepository;

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
        game.getEncounterDeck().addAll(encounterCardRepository.findAll());
        game.getEventDeck().addAll(eventCardRepository.findAll());
        game.getMonsterDeck().addAll(monsterCardRepository.findAll());
        game.getHeadlineDeck().addAll(headlineCardRepository.findAll());
        game.getMythosCup().addAll(mythosTokenRepository.findAll());

        System.out.println("Game initialized with all decks loaded.");
    }

    public Game getCurrentGame() {
        return game;
    }
}
