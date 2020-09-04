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
public class ZadanieDomowe{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String tresc;
	
	@Nullable
	@OneToMany(mappedBy = "zadanieDomowe")
	private Set<Ocena> ocena = new HashSet<Ocena>();

	public ZadanieDomowe() {}

	public ZadanieDomowe(@NotBlank String tresc) {
		this.tresc = tresc;
	}

	public String getTresc() {
		return tresc;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	public Set<Ocena> getOcena() {
		return ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena.add(ocena);
	}
	
	


}
