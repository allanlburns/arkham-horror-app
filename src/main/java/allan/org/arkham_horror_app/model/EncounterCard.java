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
    private String set;
}
