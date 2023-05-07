package service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;

import entite.ClassementParCircuit;
import entite.ClassementParGenre;
import entite.Participant;
import enumeration.GenreEnum;

public class ClassementService {

	public ClassementParGenre calculClassementParGenre(List<Participant> participants) {
		List<Participant> listFemmes = new ArrayList<>();
		List<Participant> listHommes = new ArrayList<>();

		for (Participant p : participants) {
			if (p.getGenre().equals(GenreEnum.FEMME)) {
				listFemmes.add(p);
			} else {
				listHommes.add(p);
			}
		}

		triList(listFemmes);
		triList(listHommes);

		Map<GenreEnum, List<Participant>> participantParGenre = new HashMap<>();
		participantParGenre.put(GenreEnum.FEMME, listFemmes);
		participantParGenre.put(GenreEnum.HOMME, listHommes);

		return new ClassementParGenre(participantParGenre);

	}
// du moins rapide au plus rapide 
	private void triList(List<Participant> participants) {
		int taille = participants.size();
		Participant tmp;
		for (int i = 0; i < taille; i++) {
			for (int j = 1; j < (taille - i); j++) {
				if (participants.get(j - 1).getTempsTotal().compareTo(participants.get(j).getTempsTotal()) > 0) {

					// echanges des elements
					tmp = participants.get(j - 1);
					participants.set(j - 1, participants.get(j));
					participants.set(j, tmp);
				}

			}
		}
	
	}

	
	
}
