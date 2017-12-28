package adminConsole;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Witamy w programie!");
		while (true) {
			System.out.println("Wybierz moduł: user, exercise, group lub quit:");
			String input = scan.nextLine();
			if (input.equals("user")) {
				UserAdmin.main(null);
			} else if (input.equals("exercise")) {
				ExerciseAdmin.main(null);
			} else if (input.equals("group")) {
				GroupAdmin.main(null);
			} else if (input.equals("quit")) {
				if (areYouSure(scan)) {
					break;
				}
			} else {
				System.out.println("Błąd wyboru");
			}

		}

	}

	public static boolean areYouSure(Scanner scan) {
		System.out.println("Czy na pewno? (T/N)");

		if (scan.next().equals("T")) {
			return true;
		}
		scan.nextLine();
		return false;
	}
}
