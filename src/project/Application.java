package project;

import java.util.Scanner;

public class Application {
	private static final String STOP = "STOP";
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Bienvenu dans le gestionnaire du classement");
		String input;

		do {

			System.out.println("Taper 1 pour afficher le classement par epreuve");
			System.out.println("Taper STOP si vous voulez quitter l'application ");
			/*
			 * System.out.println("Tapez 2 pour ....."); System.out.println("Tapez 3");
			 */
			// System.out.println(scanner.nextLine());
			input = scanner.nextLine();
			switch (input) {
			case "1":
				System.out.println("classement par epreuve");
				break;

			case "2":
				break;
			case "3":
				break;
			}

		} while (!input.equals(STOP));

		System.out.println("Fermeture de l'application");

	}

}
