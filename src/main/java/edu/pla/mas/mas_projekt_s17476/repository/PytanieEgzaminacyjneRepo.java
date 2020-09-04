package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;

public interface PytanieEgzaminacyjneRepo extends CrudRepository<PytanieEgzaminacyjne, Long>{

	@Query("SELECT c FROM PytanieEgzaminacyjne c LEFT JOIN FETCH c.egzaminy")
	List<PytanieEgzaminacyjne> findAllEagerly();
	
}
