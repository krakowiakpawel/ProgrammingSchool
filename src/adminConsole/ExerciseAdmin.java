package adminConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.coderslab.model.Exercise;

public class ExerciseAdmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Moduł EXERCISE!");
		while (true) {
			System.out.println("[EXERCISE] Wybierz funkcję: add, edit, delete lub back:");
			String input = scan.nextLine();
			if (input.equals("add")) {
				addExercise();
			} else if (input.equals("edit")) {
				editExercise();
			} else if (input.equals("delete")) {
				deleteExercise();
			} else if (input.equals("back")) {
				if (Application.areYouSure(scan)) {
					break;
				}
			} else {
				System.out.println("Błąd wyboru");
			}
		}
	}

	private static void deleteExercise() {
		Scanner scan = new Scanner(System.in);
		printExercises();
		System.out.println("Podaj id Exercise do kasacji:");
		int id = getId(scan);

		Exercise.loadById(id).delete();
		System.out.println("Deleted!");
	}

	private static void editExercise() {
		Scanner scan = new Scanner(System.in);
		printExercises();

		System.out.println("Podaj id użytkwnika do edycji:");
		int id = getId(scan);

		Exercise temp = createExercise();
		temp.setId(id);

		System.out.println(temp.toString());

		temp.saveToDB();
		System.out.println("Zmieniono dane!");

	}

	private static void addExercise() {
		createExercise().saveToDB();
		System.out.println("Dodano!");

	}

	private static Exercise createExercise() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Podaj Tytuł:");
		String Exercistitle = scan.nextLine();

		System.out.println("Podaj description:");
		String description = scan.nextLine();

		Exercise newExercise = new Exercise(Exercistitle, description);
		return newExercise;
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

	static void printExercises() {
		System.out.println("Lista dostępnych Exercise");
		List<Exercise> ExerciseList = Exercise.loadAll();
		for (Exercise Exercise : ExerciseList) {
			System.out.println(Exercise);
		}
	}

}