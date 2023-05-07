package project;

import java.util.List;
import java.util.Scanner;

import entite.ClassementParGenre;
import entite.Participant;
import service.ClassementService;
public class Application {
	private static final String STOP = "STOP";
	private static final Scanner scanner = new Scanner(System.in);
	private static ConnexionSqlite connec = new ConnexionSqlite();

	public static void main(String[] args) {

		System.out.println("Bienvenu dans le gestionnaire du classement");
		String input;

		do {

			System.out.println("Taper 1 pour afficher le classement par Genre");
			System.out.println("Taper STOP si vous voulez quitter l'application ");

			input = scanner.nextLine();
			switch (input) {
			case "1":
				System.out.println("classement par Genre");
				gestionDeClassement();
				break;
			}

		} while (!input.equals(STOP));

		System.out.println("Fermeture de l'application");

	}

	private static void gestionDeClassement() {
		ClassementService service =new ClassementService();
		List<Participant> participants =connec.retrieveParticipant();
		ClassementParGenre classement =service.calculClassementParGenre(participants);
		System.out.println(classement.toString());
		
	}
}
