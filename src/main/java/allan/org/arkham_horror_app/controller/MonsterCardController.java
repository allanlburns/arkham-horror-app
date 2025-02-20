package allan.org.arkham_horror_app.controller;

import allan.org.arkham_horror_app.model.MonsterCard;
import allan.org.arkham_horror_app.service.MonsterCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonsterCardController {

    @Autowired
    MonsterCardService monsterCardService;

    @GetMapping("/monsterCards")
    public ResponseEntity<List<MonsterCard>> getAllMonsterCards() {
        return new ResponseEntity<>(monsterCardService.getAllMonsterCards(), HttpStatus.OK);
    }

    @GetMapping("/monsterCard/name/{name}")
    public ResponseEntity<MonsterCard> getMonsterCardByName(@PathVariable String name) {
        return new ResponseEntity<>(monsterCardService.getMonsterCardByName(name), HttpStatus.OK);
    }

    @GetMapping("/monsterCard/type/{type}")
    public ResponseEntity<List<MonsterCard>> getMonsterCardByType(@PathVariable String type) {
        return new ResponseEntity<>(monsterCardService.getMonsterCardByType(type), HttpStatus.OK);
    }
}
