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

}
