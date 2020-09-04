package edu.pla.mas.mas_projekt_s17476.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class Ocena {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private LocalDate dataWystawienia;
	
	private int ocena;
	
	private String komentarz;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "uczen_id")
	private Uczen uczen;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "egzamin_id")
	private Egzamin egzamin;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "zadanieDomowe_id")
	private ZadanieDomowe zadanieDomowe;
	
	public Ocena() {}

	public Ocena(LocalDate dataWystawienia, int ocena, String komentarz, Uczen uczen, Egzamin egzamin) {
		super();
		this.dataWystawienia = dataWystawienia;
		this.ocena = ocena;
		this.komentarz = komentarz;
		this.uczen = uczen;
		uczen.setOcena(this);
		this.egzamin = egzamin;
		egzamin.setOcena(this);
	}
	
	public Ocena(LocalDate dataWystawienia, int ocena, String komentarz, Uczen uczen, ZadanieDomowe zadanieDomowe) {
		super();
		this.dataWystawienia = dataWystawienia;
		this.ocena = ocena;
		this.komentarz = komentarz;
		this.uczen = uczen;
		uczen.setOcena(this);
		this.zadanieDomowe = zadanieDomowe;
		zadanieDomowe.setOcena(this);
	}

	public LocalDate getDataWystawienia() {
		return dataWystawienia;
	}

	public void setDataWystawienia(LocalDate dataWystawienia) {
		this.dataWystawienia = dataWystawienia;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getKomentarz() {
		return komentarz;
	}

	public void setKomentarz(String komentarz) {
		this.komentarz = komentarz;
	}

	public Uczen getUczen() {
		return uczen;
	}

	public void setUczen(Uczen uczen) {
		this.uczen = uczen;
	}

	public Egzamin getEgzamin() {
		return egzamin;
	}

	public void setEgzamin(Egzamin egzamin) {
		this.egzamin = egzamin;
	}
	
	
	
}
