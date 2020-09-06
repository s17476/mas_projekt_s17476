package edu.pla.mas.mas_projekt_s17476.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class PytanieEgzaminacyjne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String trescPytania;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection(targetClass = String.class)
	private List<String> zleOdpowiedzi = new ArrayList<>();
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection(targetClass = String.class)
	private List<String> dobreOdpowiedzi = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "przedmiot_id")
	private Przedmiot przedmiot;
	
	@ManyToMany(
			mappedBy = "pytania"
			)
	Set<Egzamin> egzaminy = new HashSet<Egzamin>();

	public PytanieEgzaminacyjne() {}

	public PytanieEgzaminacyjne(@NotBlank String trescPytania, List<String> zleOdpowiedzi, List<String> dobreOdpowiedzi,
			Przedmiot przedmiot) {
		this.trescPytania = trescPytania;
		this.zleOdpowiedzi = zleOdpowiedzi;
		this.dobreOdpowiedzi = dobreOdpowiedzi;
		this.przedmiot = przedmiot;
	}

	public String getTrescPytania() {
		return trescPytania;
	}

	public void setTrescPytania(String trescPytania) {
		this.trescPytania = trescPytania;
	}

	public List<String> getZleOdpowiedzi() {
		return zleOdpowiedzi;
	}

	public void setZleOdpowiedzi(List<String> zleOdpowiedzi) {
		this.zleOdpowiedzi = zleOdpowiedzi;
	}

	public List<String> getDobreOdpowiedzi() {
		return dobreOdpowiedzi;
	}

	public void setDobreOdpowiedzi(List<String> dobreOdpowiedzi) {
		this.dobreOdpowiedzi = dobreOdpowiedzi;
	}

	public Przedmiot getPrzedmiot() {
		return przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

	public Set<Egzamin> getEgzaminy() {
		return egzaminy;
	}

	public void setEgzaminy(Egzamin egzaminy) {
		this.egzaminy.add(egzaminy);
	}

	@Override
	public String toString() {
		if(trescPytania.length() > 55)
			return trescPytania.substring(0, 52) + "...";
		return "" +trescPytania;
	}
	
	public void getRightAnswer() {}
	
	public void addAnswer() {}
	
	public void delAnswer() {}
	
	public void getRandomAnswers() {}
	
	public void usun() {}
	
}
