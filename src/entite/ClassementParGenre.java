package entite;

import java.util.*;

import enumeration.GenreEnum;

public class ClassementParGenre {
	private Map<GenreEnum, List<Participant>> participantParGenre;

	public ClassementParGenre(Map<GenreEnum, List<Participant>> participantParGenre) {
		super();
		this.participantParGenre = participantParGenre;
	}

	public Map<GenreEnum, List<Participant>> getParticipantParGenre() {
		return participantParGenre;
	}

	public void setParticipantParGenre(Map<GenreEnum, List<Participant>> participantParGenre) {
		this.participantParGenre = participantParGenre;

	}

	// affichage de classement par genre
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("| Classement Femmes |\n");
		sb.append("| Nom | Temp | \n");
		

		for (Participant femme : participantParGenre.get(GenreEnum.FEMME)) {
			sb.append(femme.getNom() + " | " + femme.getTempsTotal().getSeconds()+" secondes ");

		}

		sb.append("\n\n| Classement Homme |\n");
		sb.append("| Nom | Temp | \n");

		for (Participant homme : participantParGenre.get(GenreEnum.HOMME)) {
			sb.append(homme.getNom() + " | " + homme.getTempsTotal().getSeconds()+" secondes ");

		}

		return sb.toString();
	}

}
