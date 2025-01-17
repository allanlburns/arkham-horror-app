package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.ArchiveCard;
import allan.org.arkham_horror_app.model.EncounterCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncounterCardRepository extends JpaRepository<EncounterCard, Long> {

    List<EncounterCard> findEncounterCardsByNeighborhood(String neighborhood);
}
