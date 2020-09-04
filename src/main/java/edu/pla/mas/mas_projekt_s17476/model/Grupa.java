package edu.pla.mas.mas_projekt_s17476.model;

import java.time.LocalDate;
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
public class Grupa {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public LocalDate rokSzkolny;
	
	@NotBlank
	public String numerGrupy;
	
	
	@OneToMany(mappedBy = "grupa")
	public Set<Uczen> listaUcznow = new HashSet<Uczen>();
	
	@Nullable
	@OneToMany(mappedBy = "przedmiot")
	private Set<PrzedmiotGrupa> przedmiotGrupa = new HashSet<PrzedmiotGrupa>();
	
	public Grupa() {}
	
	

	public Grupa(LocalDate rokSzkolny, String numerGrupy) {
		this.rokSzkolny = rokSzkolny;
		this.numerGrupy = numerGrupy;
	}



	public LocalDate getRokSzkolny() {
		return rokSzkolny;
	}



	public void setRokSzkolny(LocalDate rokSzkolny) {
		this.rokSzkolny = rokSzkolny;
	}



	public String getNumerGrupy() {
		return numerGrupy;
	}



	public void setNumerGrupy(String numerGrupy) {
		this.numerGrupy = numerGrupy;
	}



	public Set<Uczen> getListaUcznow() {
		return listaUcznow;
	}



	public void setListaUcznow(Uczen uczen) {
		this.listaUcznow.add(uczen);
	}



	public Set<PrzedmiotGrupa> getPrzedmiotGrupa() {
		return przedmiotGrupa;
	}



	public void setPrzedmiotGrupa(PrzedmiotGrupa przedmiotGrupa) {
		this.przedmiotGrupa.add(przedmiotGrupa);
	}



	@Override
	public String toString() {
		return "Grupa [numerGrupy=" + numerGrupy + "]";
	}
	
	
	
}
