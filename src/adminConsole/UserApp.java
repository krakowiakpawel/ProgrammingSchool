package adminConsole;

import java.util.Scanner;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;

public class UserApp {

	// public static long userId = 7;
	public static void main(String[] args) {
		// userId = Long.parseLong(args[0]);
		UserAdmin.printUsers();
		System.out.println("Podaj swoje Id");
		Scanner scan = new Scanner(System.in);
		int userId = UserAdmin.getId(scan);
		scan.nextLine();
		System.out.println("Moduł Użytkownika o id= " + userId);
		while (true) {
			System.out.println("[USER] Wybierz funkcję: add, view lub quit:");
			String input = scan.nextLine();
			if (input.equals("add")) {
				addUserSolution(userId);
			} else if (input.equals("view")) {
				viewUserSolution(userId);

			} else if (input.equals("quit")) {
				if (Application.areYouSure(scan)) {
					break;
				}
			} else {
				System.out.println("Błąd wyboru");
			}
		}

	}

	private static void viewUserSolution(int userId) {

		System.out.println(Solution.loadAllByUserId(userId));

	}

	private static void addUserSolution(int userId) {
		System.out.println(Exercise.loadAllByUserId(userId));
		System.out.println("Podaj nr ćwiczenia, do którego chesz podać rozwiązanie");
		Scanner scan = new Scanner(System.in);
		int exId = ExerciseAdmin.getId(scan);
		System.out.println("Podaj Rozwiązanie");
		scan.nextLine();
		String description = scan.nextLine();

		Solution userSol = Solution.loadByExerciseIdAndSUserId(exId, userId);
		userSol.setDescription(description);
		userSol.saveToDB();
	}

}
