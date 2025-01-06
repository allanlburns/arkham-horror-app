package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.ArchiveCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveCardRepository extends JpaRepository<ArchiveCard, Long> {
    ArchiveCard findByNumber(int number);
}
