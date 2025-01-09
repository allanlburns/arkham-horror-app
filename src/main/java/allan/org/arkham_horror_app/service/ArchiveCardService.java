package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.ArchiveCard;
import allan.org.arkham_horror_app.repository.ArchiveCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveCardService {

    @Autowired
    private ArchiveCardRepository archiveCardRepository;

    public List<ArchiveCard> getAllArchiveCards() {
        return archiveCardRepository.findAll();
    }

    public ArchiveCard getArchiveCardByNum(int number) {
        return archiveCardRepository.findByNumber(number);
    }

    // Service methods for Codex
    public void addToCodex(int cardNumber) {
        ArchiveCard card = getArchiveCardByNum(cardNumber);
        card.setInCodex(true);
        archiveCardRepository.save(card);
    }

    public void removeFromCodex(int cardNumber) {
        ArchiveCard card = getArchiveCardByNum(cardNumber);
        card.setInCodex(false);
        archiveCardRepository.save(card);
    }

    public List<ArchiveCard> getCodexCards() {
        return archiveCardRepository.findByInCodexTrue();
    }
}
