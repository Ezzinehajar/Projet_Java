package entite;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
	private List<Epreuve> epreuves = new ArrayList<>();
	
	private String nom;

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Circuit(List<Epreuve> epreuves, String nom) {
		super();
		this.epreuves = epreuves;
		this.nom = nom;
	}

}
