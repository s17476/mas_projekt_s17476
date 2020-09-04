package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pla.mas.mas_projekt_s17476.model.ZadanieDomowe;

public interface ZadanieDomoweRepo extends CrudRepository<ZadanieDomowe, Long>{

	@Query("SELECT c FROM ZadanieDomowe c LEFT JOIN FETCH c.ocena")
	List<ZadanieDomowe> findAllEagerly();

}
