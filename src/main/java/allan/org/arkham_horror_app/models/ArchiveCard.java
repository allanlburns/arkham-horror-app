package allan.org.arkham_horror_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ArchiveCard extends Card{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String text;
    private String flipCondition;

    public ArchiveCard(Long id, int number, String flipCondition, String text) {
        this.id = id;
        this.number = number;
        this.flipCondition = flipCondition;
        this.text = text;
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

    public String getFlipCondition() {
        return flipCondition;
    }

    public void setFlipCondition(String flipCondition) {
        this.flipCondition = flipCondition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ArchiveCard{" +
                "id=" + id +
                ", number=" + number +
                ", text='" + text + '\'' +
                ", flipCondition='" + flipCondition + '\'' +
                '}';
    }
}
