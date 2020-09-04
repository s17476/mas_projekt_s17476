package edu.pla.mas.mas_projekt_s17476.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pla.mas.mas_projekt_s17476.model.Przedmiot;

public interface PrzedmiotRepo extends CrudRepository<Przedmiot, Long>{

	@Query("SELECT c FROM Przedmiot c LEFT JOIN FETCH c.przedmiotGrupa")
	List<Przedmiot> findAllEagerly();

}
