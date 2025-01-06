package allan.org.arkham_horror_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class ArchiveCard extends Card{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String flavorText;
    @Column(columnDefinition = "TEXT")
    private String effect;
    @Column(columnDefinition = "TEXT")
    private String flippedEffect;

    public ArchiveCard(Long id, int number, String title, String flavorText, String effect, String flippedEffect) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.flavorText = flavorText;
        this.effect = effect;
        this.flippedEffect = flippedEffect;
    }

    public ArchiveCard() {

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getFlippedEffect() {
        return flippedEffect;
    }

    public void setFlippedEffect(String flippedEffect) {
        this.flippedEffect = flippedEffect;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @Override
    public String toString() {
        return "ArchiveCard{" +
                "id=" + id +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", flavorText='" + flavorText + '\'' +
                ", effect='" + effect + '\'' +
                ", flippedEffect='" + flippedEffect + '\'' +
                '}';
    }
}
