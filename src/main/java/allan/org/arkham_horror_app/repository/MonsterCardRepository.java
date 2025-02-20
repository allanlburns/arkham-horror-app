package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.MonsterCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterCardRepository extends JpaRepository<MonsterCard, Long> {
    MonsterCard getMonsterCardByName(String name);

    List<MonsterCard> getMonsterCardByType(String type);
}
