package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.EventCard;
import allan.org.arkham_horror_app.service.EventCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventCardRepository extends JpaRepository<EventCard, Long> {

    List<EventCard> findEventCardsByScenario(String scenario);
}
