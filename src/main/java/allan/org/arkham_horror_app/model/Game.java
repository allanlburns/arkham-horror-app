package allan.org.arkham_horror_app.model;

import java.util.List;

public class Game {
    private int id;
//    String name;
    private String scenario;
    private String scenarioSheet;
    private List<EncounterCard> encounterDeck;
    private List<EventCard> eventDeck;
    private List<MonsterCard> monsterDeck;
    private List<HeadlineCard> headlineDeck;
    private List<MythosToken> mythosCup;

    public Game(int id, String scenario, String scenarioSheet, List<EncounterCard> encounterDeck, List<EventCard> eventDeck, List<MonsterCard> monsterDeck, List<HeadlineCard> headlineDeck, List<MythosToken> mythosCup) {
        this.id = id;
        this.scenario = scenario;
        this.scenarioSheet = scenarioSheet;
        this.encounterDeck = encounterDeck;
        this.eventDeck = eventDeck;
        this.monsterDeck = monsterDeck;
        this.headlineDeck = headlineDeck;
        this.mythosCup = mythosCup;
    }

    public Game() {
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

    public List<EncounterCard> getEncounterDeck() {
        return encounterDeck;
    }

    public void setEncounterDeck(List<EncounterCard> encounterDeck) {
        this.encounterDeck = encounterDeck;
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
