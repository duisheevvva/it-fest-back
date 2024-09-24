package itFest.repository;

import itFest.entities.ExpoParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpoRepository extends JpaRepository<ExpoParticipant,Long> {
}
