package allan.org.arkham_horror_app.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int id;
//    String name;
    private String scenario;
    private String scenarioSheet;
    // TODO: Dynamically receive neighborhood names from scenario and name variables based on parpameters
    private EncounterDeck downtownDeck;
    private EncounterDeck easttownDeck;
    private EncounterDeck rivertownDeck;
    private EncounterDeck southsideDeck;
    private EncounterDeck uptownDeck;
    private EncounterDeck streetsDeck;
    private EventDeck eventDeck;
    private MonsterDeck monsterDeck;
    private HeadlineDeck headlineDeck;
    private MythosCup mythosCup;

    public Game(int id, String scenario, String scenarioSheet, EventDeck eventDeck, MonsterDeck monsterDeck, HeadlineDeck headlineDeck, MythosCup mythosCup) {
        this.id = id;
        this.scenario = scenario;
        this.scenarioSheet = scenarioSheet;
        this.eventDeck = eventDeck;
        this.monsterDeck = monsterDeck;
        this.headlineDeck = headlineDeck;
        this.mythosCup = mythosCup;
    }

    public Game() {
        this.downtownDeck = new EncounterDeck("Downtown", new ArrayList<>());
        this.easttownDeck = new EncounterDeck("Easttown", new ArrayList<>());
        this.rivertownDeck = new EncounterDeck("Rivertown", new ArrayList<>());
        this.southsideDeck = new EncounterDeck("Southside", new ArrayList<>());
        this.uptownDeck = new EncounterDeck("Uptown", new ArrayList<>());
        this.streetsDeck = new EncounterDeck("The Streets", new ArrayList<>());
        this.eventDeck = new EventDeck();
        this.monsterDeck = new MonsterDeck();
        this.headlineDeck = new HeadlineDeck();
        this.mythosCup = new MythosCup();
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

    public EncounterDeck getDowntownDeck() {
        return downtownDeck;
    }
    public EncounterDeck getEasttownDeck() {
        return easttownDeck;
    }

    public EncounterDeck getRivertownDeck() {
        return rivertownDeck;
    }

    public EncounterDeck getSouthsideDeck() {
        return southsideDeck;
    }

    public EncounterDeck getUptownDeck() {
        return uptownDeck;
    }

    public EncounterDeck getStreetsDeck() {
        return streetsDeck;
    }

    public String getScenarioSheet() {
        return scenarioSheet;
    }

    public void setScenarioSheet(String scenarioSheet) {
        this.scenarioSheet = scenarioSheet;
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

    public void setMonsterDeck(MonsterDeck monsterDeck) {
        this.monsterDeck = monsterDeck;
    }

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
