package au.com.telstra.simcardactivator.repository;

import au.com.telstra.simcardactivator.model.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SimRepository extends JpaRepository<SimCard, String> {
}
