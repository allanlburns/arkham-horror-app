package allan.org.arkham_horror_app.service;

import allan.org.arkham_horror_app.model.MythosToken;
import allan.org.arkham_horror_app.repository.MythosRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MythosService {

    @Autowired
    MythosRepository mythosRepository;

    public List<MythosToken> getAllMythosTokens() {
        return mythosRepository.findAll();
    }

    public MythosToken getMythosTokenByType(String type) {
        return mythosRepository.findMythosTokenByType(type);
    }
}
