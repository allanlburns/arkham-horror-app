package allan.org.arkham_horror_app.repository;

import allan.org.arkham_horror_app.model.MythosToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MythosRepository extends JpaRepository<MythosToken, Long> {

    MythosToken findMythosTokenByType(String type);
}
