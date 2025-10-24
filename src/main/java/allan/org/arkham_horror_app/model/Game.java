package allan.org.arkham_horror_app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private int id;
//    String name;
    private String scenario;
    private String scenarioSheet;
    private Map<String, EncounterDeck> encounterDecks;
    private EventDeck eventDeck;
    private MonsterDeck monsterDeck;
    private HeadlineDeck headlineDeck;
    private MythosCup mythosCup;
    private Codex codex;

    // add params to constructor once Scenario details are dynamic in GameService:
    // EventDeck eventDeck, MonsterDeck monsterDeck, HeadlineDeck headlineDeck, MythosCup mythosCup
    public Game(int id, String scenario, String scenarioSheet, List<String> neighborhoodNames) {
        this.id = id;
        this.scenario = scenario;
        this.scenarioSheet = scenarioSheet;
        // TODO: Need to initialize codex
        this.encounterDecks = new HashMap<>();

        for (String neighborhood : neighborhoodNames) {
            encounterDecks.put(neighborhood, new EncounterDeck(neighborhood, List.of()));
        }

        this.eventDeck = new EventDeck();
        this.monsterDeck = new MonsterDeck();
        this.headlineDeck = new HeadlineDeck();
        this.mythosCup = new MythosCup();

        this.codex = new Codex();
    }

    public Game() {
        this.encounterDecks = new HashMap<>();
        this.eventDeck = new EventDeck();
        this.monsterDeck = new MonsterDeck();
        this.headlineDeck = new HeadlineDeck();
        this.mythosCup = new MythosCup();

        this.codex = new Codex();
    }

    public Codex getCodex() {
        return codex;
    }

    public void setCodex(Codex codex) {
        this.codex = codex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getScenarioSheet() {
        return scenarioSheet;
    }

    public void setScenarioSheet(String scenarioSheet) {
        this.scenarioSheet = scenarioSheet;
    }

    public EncounterDeck getEncounterDeck(String neighborhood) {
        return encounterDecks.get(neighborhood);
    }

    public Map<String, EncounterDeck> getEncounterDecks() {
        return encounterDecks;
    }

    public void setEncounterDecks(Map<String, EncounterDeck> encounterDecks) {
        this.encounterDecks = encounterDecks;
    }

    public void addEncounterDeck(String neighborhood, EncounterDeck deck) {
        encounterDecks.put(neighborhood, deck);
    }

    public EventDeck getEventDeck() {
        return eventDeck;
    }

    public void setEventDeck(EventDeck eventDeck) {
        this.eventDeck = eventDeck;
    }

    public MonsterDeck getMonsterDeck() {
        return monsterDeck;
    }

    public void setMonsterDeck(MonsterDeck monsterDeck) { this.monsterDeck = monsterDeck; }

    public HeadlineDeck getHeadlineDeck() {
        return headlineDeck;
    }

    public void setHeadlineDeck(HeadlineDeck headlineDeck) {
        this.headlineDeck = headlineDeck;
    }

    public MythosCup getMythosCup() {
        return mythosCup;
    }

    public void setMythosCup(MythosCup mythosCup) {
        this.mythosCup = mythosCup;
    }
}
