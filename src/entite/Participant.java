package entite;

import java.util.*;

public class Participant {
	private String nom;
	private String prenom;
	private String genre;
	private Map<Epreuve, Chrono> chronoParEpreuve = new HashMap<>();

	public Participant(String nom, String prenom, String genre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
	}

	public Participant(String nom, String prenom, String genre, Map<Epreuve, Chrono> chronoParEpreuve) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.chronoParEpreuve = chronoParEpreuve;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Map<Epreuve, Chrono> getChronoParEpreuve() {
		return chronoParEpreuve;
	}

	public void setChronoParEpreuve(Map<Epreuve, Chrono> chronoParEpreuve) {
		this.chronoParEpreuve = chronoParEpreuve;
	}

}
