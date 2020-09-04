package edu.pla.mas.mas_projekt_s17476.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class PrzedmiotGrupa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "przedmiot_id")
	private Przedmiot przedmiot;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "grupa_id")
	private Grupa grupa;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dydaktyk_id")
	private KadraDydaktyczna dydaktyk;
	
	@ManyToMany(
			mappedBy = "przedmiotGrupa"
			)
	Set<Egzamin> egzaminy = new HashSet<Egzamin>();
	
	
	public PrzedmiotGrupa() {}

	public PrzedmiotGrupa(Przedmiot przedmiot, Grupa grupa, KadraDydaktyczna dydaktyk) {
		this.przedmiot = przedmiot;
		przedmiot.setPrzedmiotGrupa(this);
		
		this.grupa = grupa;
		grupa.setPrzedmiotGrupa(this);
		
		this.dydaktyk = dydaktyk;
		dydaktyk.setPrzedmiotGrupa(this);
		
	}
	
	public Przedmiot getPrzedmiot() {
		return przedmiot;
	}


	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
		przedmiot.setPrzedmiotGrupa(this);
	}


	public KadraDydaktyczna getDydaktyk() {
		return dydaktyk;
	}


	public void setDydaktyk(KadraDydaktyczna dydaktyk) {
		this.dydaktyk = dydaktyk;
		dydaktyk.setPrzedmiotGrupa(this);
	}


	public Grupa getGrupa() {
		return grupa;
	}


	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
		grupa.setPrzedmiotGrupa(this);
	}

	public Set<Egzamin> getEgzaminy() {
		return egzaminy;
	}

	public void setEgzaminy(Egzamin egzaminy) {
		this.egzaminy.add(egzaminy);
	}
	
	
	
}
