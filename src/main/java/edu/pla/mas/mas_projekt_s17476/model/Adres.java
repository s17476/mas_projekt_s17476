package edu.pla.mas.mas_projekt_s17476.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Entity
public class Adres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String ulica;
	
	@NotBlank
	private String nrDomu;
	
	@NotBlank
	private String miejscowosc;
	
	@NotBlank
	private String kodPocztowy;
	
	@NotBlank
	private String telefon;
	
	/*
	 * jedna osoba może mieć kilka adresów
	 * np. korespondencyjny i zameldowania
	 */
	@ManyToOne
	@JoinColumn(name = "osoba_id")
	private Osoba osoba;
	
	public Adres() {
	}

	public Adres(String ulica, String nrDomu, String miejscowosc, String kodPocztowy, String telefon) {
		this.ulica = ulica;
		this.nrDomu = nrDomu;
		this.miejscowosc = miejscowosc;
		this.kodPocztowy = kodPocztowy;
		this.telefon = telefon;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNrDomu() {
		return nrDomu;
	}

	public void setNrDomu(String nrDomu) {
		this.nrDomu = nrDomu;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Adres [ulica=" + ulica + ", nrDomu=" + nrDomu + ", miejscowosc=" + miejscowosc + ", kodPocztowy="
				+ kodPocztowy + ", telefon=" + telefon + "]";
	}

}
