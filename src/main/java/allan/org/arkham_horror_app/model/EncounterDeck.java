package allan.org.arkham_horror_app.model;

import java.util.List;

public class EncounterDeck extends Deck {
    String neighborhood;
    List<Card> cards;

    public EncounterDeck(String neighborhood, List<Card> cards) {
        this.neighborhood = neighborhood;
        this.cards = cards;
    }

    public EncounterDeck() {
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
