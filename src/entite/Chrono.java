package entite;

import java.time.LocalDate;

public class Chrono {
	private LocalDate heureDepart;
	private LocalDate heureArrivee;

	public Chrono(LocalDate heureDepart, LocalDate heureArrivee) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	public LocalDate getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalDate heureDepart) {
		this.heureDepart = heureDepart;
	}

	public LocalDate getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(LocalDate heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
}
