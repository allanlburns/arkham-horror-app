package allan.org.arkham_horror_app.model;

import java.util.ArrayList;

public class MonsterDeck extends Deck {
    public MonsterDeck() {
        super();
    }

    public MonsterCard drawFromBottom() {
        return (MonsterCard) super.drawFromBottom();
    }
}
