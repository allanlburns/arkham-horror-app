package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.ArchiveCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchiveCardRepository extends JpaRepository<ArchiveCard, Long> {
    ArchiveCard findByNumber(int number);

    List<ArchiveCard> findByInCodexTrue();
}
