package allan.org.arkham_horror_app.model;

import jakarta.persistence.*;

@Entity
public class EncounterCard extends Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String neighborhood;
    private String number;
    private String location1;
    private String location2;
    private String location3;
    @Column(columnDefinition = "TEXT")
    private String location1Text;
    @Column(columnDefinition = "TEXT")
    private String location2Text;
    @Column(columnDefinition = "TEXT")
    private String location3Text;
    private String gameSet;

    public EncounterCard(Long id, String neighborhood, String number, String location1, String location3, String location2, String location1Text, String location2Text, String location3Text, String gameSet) {
        this.id = id;
        this.neighborhood = neighborhood;
        this.number = number;
        this.location1 = location1;
        this.location3 = location3;
        this.location2 = location2;
        this.location1Text = location1Text;
        this.location2Text = location2Text;
        this.location3Text = location3Text;
        this.gameSet = gameSet;
    }

    public EncounterCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getLocation3() {
        return location3;
    }

    public void setLocation3(String location3) {
        this.location3 = location3;
    }

    public String getLocation1Text() {
        return location1Text;
    }

    public void setLocation1Text(String location1Text) {
        this.location1Text = location1Text;
    }

    public String getLocation2Text() {
        return location2Text;
    }

    public void setLocation2Text(String location2Text) {
        this.location2Text = location2Text;
    }

    public String getGameSet() {
        return gameSet;
    }

    public void setGameSet(String gameSet) {
        this.gameSet = gameSet;
    }

    public String getLocation3Text() {
        return location3Text;
    }

    public void setLocation3Text(String location3Text) {
        this.location3Text = location3Text;
    }
}
