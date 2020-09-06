package edu.pla.mas.mas_projekt_s17476.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.swing.JCheckBox;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.Nullable;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class Egzamin{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String tytul;
	
	@Nullable
	private int iloscPunktow;
	
	
	public int dostepnyCzas;
	
	public LocalDate dostepnyOd;
	public LocalDate dostepnyDo;
	
	@Nullable
	@OneToMany(mappedBy = "egzamin")
	private Set<Ocena> ocena = new HashSet<Ocena>();
	
	//public Ocena ocena;
	
	@ManyToMany
	@JoinTable(
			name = "przedmiotGrupa_egzamin",
			joinColumns = @JoinColumn(name = "egzamin_id"),
			inverseJoinColumns = @JoinColumn(name = "przedmiotGrupa_id")
			)
	private Set<PrzedmiotGrupa> przedmiotGrupa = new HashSet<PrzedmiotGrupa>();
	
	//@Size(min = 1, max = 10)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "pytanie_egzamin",
			joinColumns = @JoinColumn(name = "egzamin_id"),
			inverseJoinColumns = @JoinColumn(name = "pytania_id")
			)
	private Set<PytanieEgzaminacyjne> pytania = new HashSet<PytanieEgzaminacyjne>();

	public Egzamin() {}

	public Egzamin(@NotBlank String tytul, int iloscPunktow, int dostepnyCzas, LocalDate dostepnyOd,
			LocalDate dostepnyDo, PrzedmiotGrupa przedmiotGrupa,
			@Size(min = 1, max = 10) Set<PytanieEgzaminacyjne> pytania) {
		this.tytul = tytul;
		this.iloscPunktow = iloscPunktow;
		this.dostepnyCzas = dostepnyCzas;
		this.dostepnyOd = dostepnyOd;
		this.dostepnyDo = dostepnyDo;
		this.przedmiotGrupa.add(przedmiotGrupa);
		przedmiotGrupa.setEgzaminy(this);
		this.pytania = pytania;
		var list = pytania;
		list.forEach(x -> x.setEgzaminy(this));
		
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public int getIloscPunktow() {
		return iloscPunktow;
	}

	public void setIloscPunktow(int iloscPunktow) {
		this.iloscPunktow = iloscPunktow;
	}

	public int getDostepnyCzas() {
		return dostepnyCzas;
	}

	public void setDostepnyCzas(int dostepnyCzas) {
		this.dostepnyCzas = dostepnyCzas;
	}

	public LocalDate getDostepnyOd() {
		return dostepnyOd;
	}

	public void setDostepnyOd(LocalDate dostepnyOd) {
		this.dostepnyOd = dostepnyOd;
	}

	public LocalDate getDostepnyDo() {
		return dostepnyDo;
	}

	public void setDostepnyDo(LocalDate dostepnyDo) {
		this.dostepnyDo = dostepnyDo;
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

	
	
	public Set<Ocena> getOcena() {
		return ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena.add(ocena);
	}

	@Override
	public String toString() {
		List<PytanieEgzaminacyjne> pytanie = new ArrayList<>();
		pytanie.addAll(pytania);
		return tytul + " z przedmiotu " + pytanie.get(0).getPrzedmiot();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public List<PytanieEgzaminacyjne> getPytaniaEgzaminacyjne(){
		List<PytanieEgzaminacyjne> pytanie = new ArrayList<>();
		pytanie.addAll(pytania);
		return pytanie;
	}
	
	public int check(Map<PytanieEgzaminacyjne, Map<String, JCheckBox>> test) {
		int punkty = 0;
		
		for(int i = 0; i < getPytaniaEgzaminacyjne().size(); i++) {
			boolean isOk = true;;
			Map<String, JCheckBox> map = test.get(getPytaniaEgzaminacyjne().get(i));
			Set<String> set = map.keySet();
			List<String> list = new ArrayList<>(); 
		    for (String x : set) 
		      list.add(x);
				//String[] pytania = (String[]) map.keySet().toArray();
				for(int j = 0; j < list.size(); j++) {
					if(map.get(list.get(j)).isSelected() && getPytaniaEgzaminacyjne().get(i).getZleOdpowiedzi().contains(list.get(j)))
						isOk = false;
					if(!map.get(list.get(j)).isSelected() && getPytaniaEgzaminacyjne().get(i).getDobreOdpowiedzi().contains(list.get(j)))
						isOk = false;
				}
			if(isOk) punkty++;
			
		}
	
	return punkty;
}
	
}
