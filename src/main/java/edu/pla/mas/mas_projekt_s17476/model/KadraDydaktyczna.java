package edu.pla.mas.mas_projekt_s17476.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.sun.istack.Nullable;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class KadraDydaktyczna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "osoba_id")
	private Osoba osoba;
	
	@Nullable
	@OneToMany(mappedBy = "dydaktyk")
	private Set<PrzedmiotGrupa> przedmiotGrupa = new HashSet<PrzedmiotGrupa>();
	
	public KadraDydaktyczna() {}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public Set<PrzedmiotGrupa> getPrzedmiotGrupa() {
		return przedmiotGrupa;
	}

	public void setPrzedmiotGrupa(PrzedmiotGrupa przedmiotGrupa) {
		this.przedmiotGrupa.add(przedmiotGrupa);
	}

	public long getId() {
		return id;
	}
	
	public void sprawdzWyniki() {}

	public void wystawOcene() {}
	
	public void stworzEgzamin() {}
	
	public void stworzPraceDomowa() {}
	
	public void edytujOcene() {}
	
	public void sprawdzPraceDomowa() {}
	
	@Override
	public String toString() {
		return "Kadra dydaktyczna";
	}
	
}
