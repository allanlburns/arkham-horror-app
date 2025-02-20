package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.MonsterCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterCardRepository extends JpaRepository<MonsterCard, Long> {
    MonsterCard getMonsterCardByName(String name);

    // Modified query to match partial results in type, for example "Ghoul Cultist" would be included for searches for "Ghoul" type. Alternative is to simplify Monster types in database and use simpler query.
    @Query("SELECT m FROM MonsterCard m WHERE LOWER(m.type) LIKE LOWER(CONCAT('%', :type, '%'))")
    List<MonsterCard> findByTypeContaining(@Param("type") String type);
}
