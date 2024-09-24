package itFest.repository;

import itFest.entities.FoodCortParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCortRepository extends JpaRepository<FoodCortParticipant,Long> {
}
