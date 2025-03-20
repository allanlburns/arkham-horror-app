package allan.org.arkham_horror_app.model;

public class Card {

    protected Long id;
    protected String name;

    public String discard() {
        return "Discard this card";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
