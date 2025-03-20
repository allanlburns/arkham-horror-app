package allan.org.arkham_horror_app.model;

import java.util.List;

public class EncounterDeck extends Deck<Card> {
    String neighborhood;

    public EncounterDeck(String neighborhood, List<Card> cards) {
        super(cards);
        this.neighborhood = neighborhood;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
