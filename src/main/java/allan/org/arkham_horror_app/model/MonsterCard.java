package allan.org.arkham_horror_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MonsterCard extends Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String health;
    private String attackModifier;
    private String evadeModifier;
    private Boolean remnant;
    private String spawnText;
    private String activationText;
    private String speed;
    private String damage;
    private String horror;
    private String text;

    public MonsterCard(Long id, String name, String type, String health, String attackModifier, String evadeModifier, Boolean remnant, String spawnText, String activationText, String speed, String damage, String horror, String text) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.health = health;
        this.attackModifier = attackModifier;
        this.evadeModifier = evadeModifier;
        this.remnant = remnant;
        this.spawnText = spawnText;
        this.activationText = activationText;
        this.speed = speed;
        this.damage = damage;
        this.horror = horror;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAttackModifier() {
        return attackModifier;
    }

    public void setAttackModifier(String attackModifier) {
        this.attackModifier = attackModifier;
    }

    public String getEvadeModifier() {
        return evadeModifier;
    }

    public void setEvadeModifier(String evadeModifier) {
        this.evadeModifier = evadeModifier;
    }

    public Boolean getRemnant() {
        return remnant;
    }

    public void setRemnant(Boolean remnant) {
        this.remnant = remnant;
    }

    public String getSpawnText() {
        return spawnText;
    }

    public void setSpawnText(String spawnText) {
        this.spawnText = spawnText;
    }

    public String getActivationText() {
        return activationText;
    }

    public void setActivationText(String activationText) {
        this.activationText = activationText;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHorror() {
        return horror;
    }

    public void setHorror(String horror) {
        this.horror = horror;
    }

    public MonsterCard() {
    }
}
