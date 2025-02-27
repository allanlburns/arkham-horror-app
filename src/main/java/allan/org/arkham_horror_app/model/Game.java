package allan.org.arkham_horror_app.model;

import java.util.List;

public class Game {
    int id;
//    String name;
    String scenario;
    String scenarioSheet;
    List<EncounterCard> encounterDeck;
    List<EventCard> eventDeck;
    List<MonsterCard> monsterDeck;
    List<HeadlineCard> headlineDeck;
    List<MythosToken> mythosCup;

}
