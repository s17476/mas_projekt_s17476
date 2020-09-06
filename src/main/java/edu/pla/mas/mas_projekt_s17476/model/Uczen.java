package edu.pla.mas.mas_projekt_s17476.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.sun.istack.Nullable;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class Uczen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "osoba_id")
	private Osoba osoba;
	
	private LocalDate dataRozpoczecia;
	
	@Nullable
	private LocalDate dataUkonczeniaSzkoly;
	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "grupa_id")
	private Grupa grupa;
	
	@Size(max = 2)
	@ManyToMany(
			mappedBy = "podopieczni"
			)
	private Set<Osoba> opiekunowie = new HashSet<Osoba>();
	
	@Nullable
	@OneToMany(mappedBy = "uczen")
	private Set<Ocena> ocena = new HashSet<Ocena>();

	public Uczen() {}
	
	public Uczen(LocalDate dataRozpoczecia, LocalDate dataUkonczeniaSzkoly, Grupa grupa) {
		this.dataRozpoczecia = dataRozpoczecia;
		this.dataUkonczeniaSzkoly = dataUkonczeniaSzkoly;
		this.grupa = grupa;
		grupa.setListaUcznow(this);
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public LocalDate getDataRozpoczecia() {
		return dataRozpoczecia;
	}

	public void setDataRozpoczecia(LocalDate dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}

	public LocalDate getDataUkonczeniaSzkoly() {
		return dataUkonczeniaSzkoly;
	}

	public void setDataUkonczeniaSzkoly(LocalDate dataUkonczeniaSzkoly) {
		this.dataUkonczeniaSzkoly = dataUkonczeniaSzkoly;
	}

	public Grupa getGrupa() {
		return grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	public Set<Osoba> getOpiekunowie() {
		return opiekunowie;
	}

	public void setOpiekunowie(Osoba osoba) {
		this.opiekunowie.add(osoba);
		osoba.setPodopieczni(this);
	}

	public long getId() {
		return id;
	}

	public Set<Ocena> getOcena() {
		return ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena.add(ocena);
	}
	
	public void przeslijPraceDomowa() {}
	
	public void pobierzMaterialy() {}
	
	public void rozwiazEgzamin() {}
	
	public void skontaktujSieZ() {}
	
	@Override
	public String toString() {
		return "Uczeń";
	}
	
}
