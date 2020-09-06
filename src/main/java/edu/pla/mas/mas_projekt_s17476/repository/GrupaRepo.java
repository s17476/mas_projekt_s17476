package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.pla.mas.mas_projekt_s17476.model.Grupa;

public interface GrupaRepo extends CrudRepository<Grupa, Long>{

	@Query("SELECT c FROM Grupa c LEFT JOIN FETCH c.przedmiotGrupa")
	List<Grupa> findAllEagerly();

	@Query("SELECT c FROM Grupa c LEFT JOIN FETCH c.przedmiotGrupa WHERE c.id = (:id)")
	Optional<Grupa> findByIdAndFetchPrzedmiotGrupa(@Param("id") Long id);

}
