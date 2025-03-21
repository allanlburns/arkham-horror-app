package allan.org.arkham_horror_app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck<T extends Card> {
    protected List<T> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public Deck(List<T> cards) {
        this.cards = (List<T>) cards;
    }

    public List<T> getCards() {
        return cards;
    }

    public void setCards(List<T> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addAll(List<? extends Card> newCards) {
        this.cards.addAll((Collection<? extends T>) newCards);
    }

    public T drawFromTop() {
        return cards.isEmpty() ? null : (T) cards.remove(0);
    }

    protected T drawFromBottom() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }
}
