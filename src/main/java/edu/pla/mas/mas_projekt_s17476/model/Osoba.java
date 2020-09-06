package edu.pla.mas.mas_projekt_s17476.model;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.Nullable;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class Osoba {
	
	@NotBlank
	private String imie;
	@NotBlank
	private String nazwisko;
	@NotBlank
	private String password;

	private LocalDate dataUrodzenia;
	
	@Id
	private String pesel;
	
	/*
	 * osoba musi posiadać przynajmniej jeden adres
	 */
	@Size(min = 1)
	@OneToMany(mappedBy = "osoba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Adres> adres = new HashSet<Adres>();
	
	/*
	 * osoba może należeć do kadry administracyjnej
	 */
	@Nullable
	@OneToOne(mappedBy = "osoba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	KadraAdministracyjna kadraAdmin;
	
	/*
	 * osoba może należeć do kadry dydaktycznej
	 */
	@Nullable
	@OneToOne(mappedBy = "osoba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	KadraDydaktyczna kadraDydaktyczna;
	
	/*
	 * osoba może należeć być uczniem
	 */
	@Nullable
	@OneToOne(mappedBy = "osoba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Uczen uczen;
	
	@Nullable
	@ManyToMany
	@JoinTable(
			name = "podopieczny_opiekun",
			joinColumns = @JoinColumn(name = "osoba_id"),
			inverseJoinColumns = @JoinColumn(name = "podopieczni_id")
			)
	private Set<Uczen> podopieczni = new HashSet<Uczen>();
	
	public Osoba() {}
	
	public Osoba(String imie, String nazwisko, String password, String pesel, String dataUrodzenia, Adres adres) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.password = password;
		this.pesel = pesel;
		this.dataUrodzenia = LocalDate.parse(dataUrodzenia);
		this.adres.add(adres);
		adres.setOsoba(this);
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public LocalDate getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(LocalDate dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}

	public Set<Adres> getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres.add(adres);
		adres.setOsoba(this);
	}
	
	public KadraAdministracyjna getKadraAdmin() {
		return kadraAdmin;
	}

	public void setKadraAdmin(KadraAdministracyjna kadraAdmin) {
		this.kadraAdmin = kadraAdmin;
		kadraAdmin.setOsoba(this);
	}

	public KadraDydaktyczna getKadraDydaktyczna() {
		return kadraDydaktyczna;
	}

	public void setKadraDydaktyczna(KadraDydaktyczna kadraDydaktyczna) {
		this.kadraDydaktyczna = kadraDydaktyczna;
		kadraDydaktyczna.setOsoba(this);
	}

	public Uczen getUczen() {
		return uczen;
	}

	public void setUczen(Uczen uczen) {
		this.uczen = uczen;
		uczen.setOsoba(this);
	}

	public Set<Uczen> getPodopieczni() {
		return podopieczni;
	}

	public void setPodopieczni(Uczen uczen) {
		
		this.podopieczni.add(uczen);
	}
	
	@Override
	public String toString() {
		return this.imie+" "+this.nazwisko+" "+this.pesel+" "+this.password + "\n" + kadraAdmin + "\n" + kadraDydaktyczna + "\n" + uczen + "\n";
	}
	
}
