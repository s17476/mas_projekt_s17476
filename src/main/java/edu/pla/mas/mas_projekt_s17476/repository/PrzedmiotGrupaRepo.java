package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.pla.mas.mas_projekt_s17476.model.PrzedmiotGrupa;

public interface PrzedmiotGrupaRepo extends CrudRepository<PrzedmiotGrupa, Long>{
	
	@Query("SELECT c FROM PrzedmiotGrupa c LEFT JOIN FETCH c.egzaminy WHERE c.id = (:id)")
	Optional<PrzedmiotGrupa> findByIdEagerly(@Param("id") Long id);
	
	@Query("SELECT c FROM PrzedmiotGrupa c LEFT JOIN FETCH c.egzaminy WHERE c.id = (:id)")
	List<PrzedmiotGrupa> findAllByIdEagerly(@Param("id") Long id);

}
