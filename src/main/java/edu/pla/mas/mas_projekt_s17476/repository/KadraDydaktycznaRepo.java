package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import edu.pla.mas.mas_projekt_s17476.model.KadraDydaktyczna;

public interface KadraDydaktycznaRepo extends CrudRepository<KadraDydaktyczna, Long>{

	@Query("SELECT c FROM KadraDydaktyczna c LEFT JOIN FETCH c.przedmiotGrupa")
	List<KadraDydaktyczna> findAllEagerly();

	@Query("SELECT c FROM KadraDydaktyczna c LEFT JOIN FETCH c.przedmiotGrupa WHERE c.id = (:id)")
	Optional<KadraDydaktyczna> findByIdAndFetchSubjects(@Param("id") Long id);

}
