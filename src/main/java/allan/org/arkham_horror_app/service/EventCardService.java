package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.EventCard;
import allan.org.arkham_horror_app.repository.EventCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCardService {

    @Autowired
    private EventCardRepository eventCardRepository;

    public List<EventCard> getAllEventCards() {
        return eventCardRepository.findAll();
    }

    public List<EventCard> getEventCardsByScenario(String scenario) {
        return eventCardRepository.findEventCardsByScenario(scenario);
    }
}
