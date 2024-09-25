package itFest.repository;

import itFest.entities.TournamentParticipant;
import itFest.enums.ThematicSectionTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentRepository extends JpaRepository<TournamentParticipant,Long> {


    @Query("SELECT tp FROM TournamentParticipant tp WHERE tp.thematicTournament = :thematicTournament")
    List<TournamentParticipant> findByThematicSection(@Param("thematicTournament") ThematicSectionTournament thematicTournament);
}
