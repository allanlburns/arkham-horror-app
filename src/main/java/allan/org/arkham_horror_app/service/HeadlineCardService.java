package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.HeadlineCard;
import allan.org.arkham_horror_app.repository.HeadlineCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadlineCardService {

    @Autowired
    private HeadlineCardRepository headlineCardRepository;

    public List<HeadlineCard> getHeadlineCards() {
        return headlineCardRepository.findAll();
    }

    public HeadlineCard getHeadlineCard(int number) {
        return headlineCardRepository.getHeadlineCardByNumber(number);
    }
}
