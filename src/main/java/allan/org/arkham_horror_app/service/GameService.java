package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.*;
import allan.org.arkham_horror_app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    // Declare variables for drawn card types:

    // === Encounter Cards ===
    // Use a map to track the last drawn card per neighborhood
    private final Map<String, Card> lastEncounterCardsDrawn = new HashMap<>();

    // === Event Cards ===
    private EventCard lastEventCardDrawnFromTop;
    private EventCard lastEventCardDrawnFromBottom;

    // === Headline Cards ===
    private HeadlineCard lastHeadlineCardDrawn;

    // === Monster Cards ===
    // TODO: Make Monster Card variable track multiple drawn Monsters
    private MonsterCard lastMonsterCardDrawn;

    // === Mythos Tokens ===
    private MythosToken lastMythosTokenDrawn;


    public void initializeGame() {

        int scenarioId = 1;
        String scenarioName = "Feast for Umordhoth";
        String scenarioSheetName = "feast_for_umordhoth";
        List<String> neighborhoods = List.of("Downtown", "Easttown", "Rivertown", "Southside", "Uptown", "The Streets");

        this.game = new Game(scenarioId, scenarioName, scenarioSheetName, neighborhoods);

        // Fetch initial Archive Cards for the Codex
        // TODO: Add specific Archive Cards to list, by number
//        List<ArchiveCard> initialCodexCards = archiveCardRepository.findByScenario("default-scenario");
//        game.getCodex().addAll(initialCodexCards);
        archiveCardService.addToCodex(1);
        archiveCardService.addToCodex(10);
        archiveCardService.addToCodex(11);

        // Fetch and initialize all the Encounter decks dynamically
        for (String neighborhood : neighborhoods) {
            List<Card> cards = new ArrayList<>(encounterCardService.getEncounterCardsByNeighborhood(neighborhood));
            EncounterDeck deck = new EncounterDeck(neighborhood, cards);
            game.addEncounterDeck(neighborhood, deck);
        }

        // Retrieve and shuffle Event Deck. TODO: parameterize Event Deck from Scenario
        game.getEventDeck().addAll(eventCardRepository.findAll());

        // Set up Headline Deck: retrieve all, shuffle, and select 13 for deck
        List<HeadlineCard> allHeadlineCards = headlineCardRepository.findAll();
        Collections.shuffle(allHeadlineCards);
        List<HeadlineCard> selectedHeadlines = allHeadlineCards.subList(0, Math.min(13, allHeadlineCards.size())); // Ensure it doesn't break if less than 13 exist
        game.getHeadlineDeck().addAll(selectedHeadlines);

        game.getMonsterDeck().addAll(monsterCardRepository.findAll());
        game.getMythosCup().addTokens(mythosTokenRepository.findAll());

        // Shuffle all decks by chaining .shuffle()
        for (EncounterDeck deck : game.getEncounterDecks().values()) {
            deck.shuffle();
        }

        game.getEventDeck().shuffle();
        game.getMonsterDeck().shuffle();
        game.getHeadlineDeck().shuffle();
        game.getMythosCup().shuffle();
        System.out.println("Game initialized with all decks loaded.");
    }

    public Game getCurrentGame() {
        return game;
    }

    public Card drawEncounterCard(String neighborhood) {
        Card card = game.getEncounterDeck(neighborhood).drawFromTop();
        lastEncounterCardsDrawn.put(neighborhood, card);
        return card;
    }

    public void placeEncounterCardOnBottom(String neighborhood) {
        Card lastCard = lastEncounterCardsDrawn.get(neighborhood);
        if (lastCard != null) {
            game.getEncounterDeck(neighborhood).getCards().add(lastCard);
            lastEncounterCardsDrawn.remove(neighborhood);
        } else {
            throw new IllegalStateException("No Encounter card drawn from " + neighborhood);
        }
    }

    public EventCard drawEventCardFromTop() {
        lastEventCardDrawnFromTop = game.getEventDeck().drawFromTop();
        return lastEventCardDrawnFromTop;
    }

    public EventCard drawEventCardFromBottom() {
        lastEventCardDrawnFromBottom = game.getEventDeck().drawFromBottom();
        return lastEventCardDrawnFromBottom;
    }

    public void discardEventCardFromTop() {
        if (lastEventCardDrawnFromTop != null) {
            game.getEventDeck().discard(lastEventCardDrawnFromTop);
            lastEventCardDrawnFromTop = null;
        }
    }

    public MonsterCard drawMonsterCard() {
        lastMonsterCardDrawn = game.getMonsterDeck().drawFromBottom();
        return lastMonsterCardDrawn;
    }

    public void returnMonsterToTop() {
        if (lastMonsterCardDrawn != null) {
            game.getMonsterDeck().getCards().add(0, lastMonsterCardDrawn);
            lastMonsterCardDrawn = null;
        }
    }

    public HeadlineCard drawHeadlineCard() {
        lastHeadlineCardDrawn = (HeadlineCard) game.getHeadlineDeck().drawFromTop();
        return lastHeadlineCardDrawn;
    }

    public void placeHeadlineCardOnBottom() {
        if (lastHeadlineCardDrawn != null) {
            game.getHeadlineDeck().getCards().add(lastHeadlineCardDrawn);
            lastHeadlineCardDrawn = null;
        }
    }

    public MythosToken drawMythosToken() {
        lastMythosTokenDrawn = game.getMythosCup().drawToken();
        return lastMythosTokenDrawn;
    }

    public void discardMythosToken() {
        if (lastMythosTokenDrawn != null) {
            game.getMythosCup().getDiscardPile().add(lastMythosTokenDrawn);
            lastMythosTokenDrawn = null;
        }
    }

    public void resetMythosCup() {
        game.getMythosCup().reshuffleDiscardIntoCup();
    }

    public Card getCardById(Long cardId) {
        // Search in all Encounter Decks
        for (EncounterDeck deck : game.getEncounterDecks().values()) {
            for (Card card : deck.getCards()) {
                if (card.getId() == cardId) {
                    return card;
                }
            }
        }
        return null; // If not found
    }


//    //    TODO: Need to define Codex class and initialize Codex in Archive. Then work on Archive Card/Codex methods

//    public void addToCodex(ArchiveCard card) {
//        game.getCodex().add(card);
//    }
}
