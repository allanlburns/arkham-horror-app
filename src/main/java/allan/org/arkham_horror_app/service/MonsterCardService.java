package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.MonsterCard;
import allan.org.arkham_horror_app.repository.MonsterCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterCardService {

    @Autowired
    MonsterCardRepository monsterCardRepository;

    public List<MonsterCard> getAllMonsterCards() {
        return monsterCardRepository.findAll();
    }

    public MonsterCard getMonsterCardByName(String name) {
        return monsterCardRepository.getMonsterCardByName(name);
    }
}
