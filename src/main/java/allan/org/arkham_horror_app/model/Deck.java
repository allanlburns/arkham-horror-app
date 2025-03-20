package allan.org.arkham_horror_app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck<T extends Card> {
    protected List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public Deck(List<T> cards) {
        this.cards = (List<Card>) cards;
    }
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addAll(List<EventCard> newCards) {
        this.cards.addAll(newCards);
    }

    public T drawFromTop() {
        return cards.isEmpty() ? null : (T) cards.remove(0);
    }
}
