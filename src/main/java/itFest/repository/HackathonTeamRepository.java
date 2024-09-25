package itFest.repository;

import itFest.entities.HackathonTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonTeamRepository extends JpaRepository<HackathonTeam,Long> {
}
