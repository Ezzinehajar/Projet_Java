package entite;

import java.time.Duration;
import java.time.LocalDateTime;

public class Chrono {
	



	private LocalDateTime heureDepart;
	private LocalDateTime heureArrivee;


	
	public LocalDateTime getHeureDepart() {
		return heureDepart;
	}



	public void setHeureDepart(LocalDateTime heureDepart) {
		this.heureDepart = heureDepart;
	}



	public LocalDateTime getHeureArrivee() {
		return heureArrivee;
	}



	public void setHeureArrivee(LocalDateTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}



	
	
	public Chrono(LocalDateTime heureDepart, LocalDateTime heureArrivee) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}



	public Duration getTempsTotal() {
		Duration tempsTotal=Duration.between(heureDepart, heureArrivee);
		return tempsTotal;
	}
}
