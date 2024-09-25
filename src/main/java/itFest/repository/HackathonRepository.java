package itFest.repository;

import itFest.entities.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonRepository extends JpaRepository<Hackathon,Long> {

}
