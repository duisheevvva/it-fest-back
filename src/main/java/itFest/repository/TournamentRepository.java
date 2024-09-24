package itFest.repository;

import itFest.entities.TournamentParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<TournamentParticipant,Long> {
}
