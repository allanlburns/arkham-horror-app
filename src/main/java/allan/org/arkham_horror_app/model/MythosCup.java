package allan.org.arkham_horror_app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MythosCup extends Deck {
    private List<MythosToken> tokens;

    private List<MythosToken> discardPile;

    public MythosCup() {
        this.tokens = new ArrayList<>();
        this.discardPile = new ArrayList<>();
    }

    public void addTokens(List<MythosToken> tokens) {
        this.tokens.addAll(tokens);
    }

    public void shuffle() {
        Collections.shuffle(tokens);
    }

    public MythosToken drawToken() {
        if (tokens.isEmpty()) {
            return null;
        }
        return tokens.remove(0);
    }

    public void reshuffleDiscardIntoCup() {
        tokens.addAll(discardPile);
        Collections.shuffle(tokens);
        discardPile.clear();
    }

    // ✅ Add this getter
    public List<MythosToken> getDiscardPile() {
        return discardPile;
    }

    // Optional getter for tokens (if needed)
    public List<MythosToken> getTokens() {
        return tokens;
    }


}
