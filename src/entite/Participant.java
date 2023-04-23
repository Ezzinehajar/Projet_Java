package entite;

import java.time.Duration;
import java.util.*;

import enumeration.GenreEnum;

public class Participant {
	private String nom;
	private String prenom;
	private GenreEnum genre;
	private Map<Epreuve, Chrono> chronoParEpreuve = new HashMap<>();

	public Participant(String nom, String prenom, GenreEnum genre) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
	}

	public Participant(String nom, String prenom, GenreEnum genre, Map<Epreuve, Chrono> chronoParEpreuve) {
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

	public GenreEnum getGenre() {
		return genre;
	}

	public void setGenre(GenreEnum genre) {
		this.genre = genre;
	}

	public Map<Epreuve, Chrono> getChronoParEpreuve() {
		return chronoParEpreuve;
	}

	public void setChronoParEpreuve(Map<Epreuve, Chrono> chronoParEpreuve) {
		this.chronoParEpreuve = chronoParEpreuve;
	}

	public Duration getTempsTotal() {
		Duration d = Duration.ZERO;
		for (Chrono c : chronoParEpreuve.values()) {
			d.plus(c.getTempsTotal());
		}

		return d;

	}
}
