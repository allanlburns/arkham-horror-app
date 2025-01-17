package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.EncounterCard;
import allan.org.arkham_horror_app.repository.EncounterCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterCardService {

    @Autowired
    EncounterCardRepository encounterCardRepository;

    public List<EncounterCard> getAllEncounterCards() {
        return encounterCardRepository.findAll();
    }

    public List<EncounterCard> getEncounterCardsByNeighborhood(String neighborhood) {
        return encounterCardRepository.findEncounterCardsByNeighborhood(neighborhood);
    }
}
