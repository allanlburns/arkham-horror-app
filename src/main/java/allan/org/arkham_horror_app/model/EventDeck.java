package allan.org.arkham_horror_app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventDeck extends Deck<EventCard> {
    private List<EventCard> discardPile;

    public EventDeck() {
        super();
        this.discardPile = new ArrayList<>();
    }

    public EventCard drawCardFromTop() {
        return super.drawFromTop();
    }

    public List<EventCard> getDiscardPile() {
        return discardPile;
    }

    public void discard(EventCard card) {
        discardPile.add(card);
    }

    public void reshuffleDiscardIntoDeck() {
        if (!discardPile.isEmpty()) {
            Collections.shuffle(discardPile);
            cards.addAll(discardPile);
            discardPile.clear();
        }
    }
}
