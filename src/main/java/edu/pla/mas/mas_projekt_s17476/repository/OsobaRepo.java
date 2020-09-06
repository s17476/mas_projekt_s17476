package edu.pla.mas.mas_projekt_s17476.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pla.mas.mas_projekt_s17476.model.Osoba;

public interface OsobaRepo extends CrudRepository<Osoba, String>{
	
	//metoda używana w ekranie logowania
	Optional<Osoba> findByPeselAndPassword(String string, String string2);

	@Query("SELECT c FROM Osoba c INNER JOIN FETCH c.adres WHERE c.pesel = (:pesel)")
	Optional<Osoba> findByPeselAndFetchAdresEagerly(@Param("pesel") String pesel);
	
	@Query("SELECT c FROM Osoba c LEFT JOIN FETCH c.podopieczni WHERE c.pesel = (:pesel)")
	Optional<Osoba> findByPeselAndFetchPodopieczniEagerly(@Param("pesel") String pesel);

	

	

}
