package adminConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

public class ExerciseManager {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Moduł ExerciseManager!");
		while (true) {
			System.out.println("[ExerciseManager] Wybierz funkcję: add, view lub back:");
			String input = scan.nextLine();
			if (input.equals("add")) {
				add();
			} else if (input.equals("view")) {
				view();

			} else if (input.equals("back")) {
				if (Application.areYouSure(scan)) {
					break;
				}
			} else {
				System.out.println("Błąd wyboru");
			}
		}
	}

	private static void view() {
		Scanner scan = new Scanner(System.in);

		UserAdmin.printUsers();
		System.out.println("Podaj id Usera");
		int id = UserAdmin.getId(scan);

		ArrayList<Solution> exList = Solution.loadAllByUserId(id);

		if (exList.isEmpty()) {
			System.out.println("Brak zadań");
		} else {
			for (Solution sol : exList) {
				System.out.println(sol);
			}
		}

	}

	private static void add() {
		Scanner sc = new Scanner(System.in);
		UserAdmin.printUsers();
		System.out.println("Podaj id Usera");
		int userID = UserAdmin.getId(sc);
		ExerciseAdmin.printExercises();
		System.out.println("Podaj id ćwiczenia");
		int exId = ExerciseAdmin.getId(sc);

		if ((Solution.loadByExerciseIdAndSUserId(exId, userID)) == null) {
			Solution sol = new Solution(null, exId, userID);
			sol.saveToDB();
			System.out.println("Sukces!");
		} else {
			System.out.println("Już istnieje!");

		}
	}

	static int getId(Scanner scan) {
		int id = 0;
		List<Exercise> uList = Exercise.loadAll();
		List<Integer> idList = new ArrayList<>();
		for (Exercise Exercise : uList) {
			int uId = Exercise.getId();
			idList.add(uId);
		}
		while (true) {

			while (!scan.hasNextInt()) {
				System.out.println("That's not a number!");
				scan.next(); // this is important!
			}
			id = scan.nextInt();
			if (!idList.contains(id)) {
				System.out.println("Wybrany numer nie istenieje");
			} else {
				return id;
			}
		}
	}

}
