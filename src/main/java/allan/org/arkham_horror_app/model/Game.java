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
    private List<EventCard> eventDeck;
    private List<MonsterCard> monsterDeck;
    private List<HeadlineCard> headlineDeck;
    private List<MythosToken> mythosCup;

    public Game(int id, String scenario, String scenarioSheet, List<EventCard> eventDeck, List<MonsterCard> monsterDeck, List<HeadlineCard> headlineDeck, List<MythosToken> mythosCup) {
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
        this.eventDeck = new ArrayList<>();
        this.monsterDeck = new ArrayList<>();
        this.headlineDeck = new ArrayList<>();
        this.mythosCup = new ArrayList<>();
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

    public List<EventCard> getEventDeck() {
        return eventDeck;
    }

    public void setEventDeck(List<EventCard> eventDeck) {
        this.eventDeck = eventDeck;
    }

    public List<MonsterCard> getMonsterDeck() {
        return monsterDeck;
    }

    public void setMonsterDeck(List<MonsterCard> monsterDeck) {
        this.monsterDeck = monsterDeck;
    }

    public List<HeadlineCard> getHeadlineDeck() {
        return headlineDeck;
    }

    public void setHeadlineDeck(List<HeadlineCard> headlineDeck) {
        this.headlineDeck = headlineDeck;
    }

    public List<MythosToken> getMythosCup() {
        return mythosCup;
    }

    public void setMythosCup(List<MythosToken> mythosCup) {
        this.mythosCup = mythosCup;
    }
}
