package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pla.mas.mas_projekt_s17476.model.KadraDydaktyczna;

public interface KadraDydaktycznaRepo extends CrudRepository<KadraDydaktyczna, Long>{

	@Query("SELECT c FROM KadraDydaktyczna c LEFT JOIN FETCH c.przedmiotGrupa")
	List<KadraDydaktyczna> findAllEagerly();

}
