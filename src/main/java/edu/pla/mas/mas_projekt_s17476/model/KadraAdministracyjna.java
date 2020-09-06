package edu.pla.mas.mas_projekt_s17476.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class KadraAdministracyjna {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String nazwaStanowiska;
	
	@NotBlank
	private String zakresObowiazkow;
	
	@OneToOne
	@JoinColumn(name = "osoba_id")
	private Osoba osoba;
	
	public KadraAdministracyjna() {}
	
	public KadraAdministracyjna(String nazwaStanowiska, String zakresObowiazkow) {
		this.nazwaStanowiska = nazwaStanowiska;
		this.zakresObowiazkow = zakresObowiazkow;
	}

	public String getNazwaStanowiska() {
		return nazwaStanowiska;
	}

	public void setNazwaStanowiska(String nazwaStanowiska) {
		this.nazwaStanowiska = nazwaStanowiska;
	}

	public String getZakresObowiazkow() {
		return zakresObowiazkow;
	}

	public void setZakresObowiazkow(String zakresObowiazkow) {
		this.zakresObowiazkow = zakresObowiazkow;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	public long getId() {
		return id;
	}

	public List<Ocena> sprawdzWyniki(Uczen uczen) {
		return null;
	}
	
	public void przypiszUczniaDoKlasy(Uczen uczen, PrzedmiotGrupa przedmiotGrupa) {}
	
	public void przypiszNauczycielaDoPrzedniotu(KadraDydaktyczna nauczyciel, PrzedmiotGrupa przedmiotGrupa) {}
	
	@Override
	public String toString() {
		return "Kadra administracyjna";
	}

}
