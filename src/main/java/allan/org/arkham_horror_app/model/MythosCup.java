package allan.org.arkham_horror_app.model;

import java.util.ArrayList;
import java.util.List;

public class MythosCup extends Deck {
    private List<MythosToken> discardPile;

    public MythosCup() {
        super();
        this.discardPile = new ArrayList<>();
    }

    public MythosToken drawToken() {
        if (cards.isEmpty()) {
            resetCup(); // If empty, refill the cup before drawing
        }
        return (MythosToken) cards.remove(0);
    }

    public void discard(MythosToken token) {
        discardPile.add(token);
    }

    public void resetCup() {
        if (!discardPile.isEmpty()) {
            cards.addAll(discardPile);
            shuffle();
            discardPile.clear();
        }
    }


}
