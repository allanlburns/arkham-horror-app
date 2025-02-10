package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.HeadlineCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadlineCardRepository extends JpaRepository<HeadlineCard, Long> {
    HeadlineCard getHeadlineCardByNumber(int number);
}
