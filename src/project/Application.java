package project;

import java.util.Scanner;

public class Application {
	private static final String STOP = "STOP";

	public static void main(String[] args) {
		System.out.println("hello");
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		while (!input.equals(STOP)) {
		//	System.out.println(scanner.nextLine()); 
			input = scanner.nextLine();
		}

	}

}
