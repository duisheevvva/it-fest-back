package itFest.repository;

import itFest.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {
}
