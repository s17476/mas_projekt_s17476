package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.Uczen;

public interface EgzaminRepo extends CrudRepository<Egzamin, Long>{
	@Query("SELECT c FROM Egzamin c LEFT JOIN FETCH c.przedmiotGrupa WHERE c.id = (:id)")
	Optional<Egzamin> findByIdEagerly(@Param("id") Long id);
	
	@Query("SELECT c FROM Egzamin c LEFT JOIN FETCH c.ocena WHERE c.id = (:id)")
	Optional<Egzamin> findByIdEagerlyAndFetchOcena(@Param("id") Long id);

}
