package edu.pla.mas.mas_projekt_s17476.model;

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
	
	@Override
	public String toString() {
		return "Kadra administracyjna";
	}

}