package allan.org.arkham_horror_app.model;

import jakarta.persistence.*;

@Entity
public class HeadlineCard extends Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String headline;
    private String type;
    private String flavorText;
    @Column(columnDefinition = "TEXT")
    private String effect;
    @Column(columnDefinition = "TEXT")
    private String reckoningEffect;
    @Column(columnDefinition = "TEXT")
    private String gameset;

    public HeadlineCard(Long id, int number, String type, String headline, String flavorText, String reckoningEffect, String effect, String gameset) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.headline = headline;
        this.flavorText = flavorText;
        this.reckoningEffect = reckoningEffect;
        this.effect = effect;
        this.gameset = gameset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getReckoningEffect() {
        return reckoningEffect;
    }

    public void setReckoningEffect(String reckoningEffect) {
        this.reckoningEffect = reckoningEffect;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getGameset() {
        return gameset;
    }

    public void setGameset(String gameset) {
        this.gameset = gameset;
    }
}
