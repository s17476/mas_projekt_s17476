package edu.pla.mas.mas_projekt_s17476.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.sun.istack.Nullable;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class Przedmiot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String nazwaPrzedmiotu;
	
	@NotBlank
	private String symbol;
	
	private String opis;
	
	@Nullable
	@OneToMany(mappedBy = "przedmiot")
	private Set<PrzedmiotGrupa> przedmiotGrupa = new HashSet<PrzedmiotGrupa>();
	
	@Nullable
	@OneToMany(mappedBy = "przedmiot")
	private Set<PytanieEgzaminacyjne> pytania = new HashSet<PytanieEgzaminacyjne>();
	
	
	
	
	public Przedmiot() {}

	public Przedmiot(String nazwaPrzedmiotu, String symbol, String opis) {
		this.nazwaPrzedmiotu = nazwaPrzedmiotu;
		this.symbol = symbol;
		this.opis = opis;
	}

	public String getNazwaPrzedmiotu() {
		return nazwaPrzedmiotu;
	}

	public void setNazwaPrzedmiotu(String nazwaPrzedmiotu) {
		this.nazwaPrzedmiotu = nazwaPrzedmiotu;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	
	
	public Set<PrzedmiotGrupa> getPrzedmiotGrupa() {
		return przedmiotGrupa;
	}

	public void setPrzedmiotGrupa(PrzedmiotGrupa przedmiotGrupa) {
		this.przedmiotGrupa.add(przedmiotGrupa);
	}

	
	
	public Set<PytanieEgzaminacyjne> getPytania() {
		return pytania;
	}

	public void setPytania(PytanieEgzaminacyjne pytania) {
		this.pytania.add(pytania);
	}


	@Override
	public String toString() {
		return "Przedmiot [nazwaPrzedmiotu=" + nazwaPrzedmiotu + ", symbol=" + symbol + ", opis=" + opis + "]";
	}
	
	
}
