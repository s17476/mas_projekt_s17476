package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.pla.mas.mas_projekt_s17476.model.Uczen;

public interface UczenRepo extends CrudRepository<Uczen, Long>{

	@Query("SELECT c FROM Uczen c LEFT JOIN FETCH c.opiekunowie WHERE c.id = (:id)")
	Optional<Uczen> findByIdAndFetchAdresEagerly(@Param("id") Long id);

	@Query("SELECT c FROM Uczen c LEFT JOIN FETCH c.ocena WHERE c.id = (:id)")
	Optional<Uczen> findByIdAndFetchOcenaEagerly(@Param("id") Long id);
}
