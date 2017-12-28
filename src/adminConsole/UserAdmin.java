package adminConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.coderslab.model.User;

public class UserAdmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Moduł USER!");
		while (true) {
			System.out.println("[USER] Wybierz funkcję: add, edit, delete lub back:");
			String input = scan.nextLine();
			if (input.equals("add")) {
				addUser();
			} else if (input.equals("edit")) {
				editUser();
			} else if (input.equals("delete")) {
				deleteUser();
			} else if (input.equals("back")) {
				if (Application.areYouSure(scan)) {
					break;
				}
			} else {
				System.out.println("Błąd wyboru");
			}
		}
	}

	private static void deleteUser() {
		Scanner scan = new Scanner(System.in);
		printUsers();
		System.out.println("Podaj id użytkwnika do kasacji:");
		int id = getId(scan);

		User.loadById(id).delete();
		System.out.println("Deleted!");
	}

	private static void editUser() {
		Scanner scan = new Scanner(System.in);
		printUsers();

		System.out.println("Podaj id użytkwnika do edycji:");
		int id = getId(scan);

		User temp = createUser();
		temp.setId(id);

		System.out.println(temp.toString());

		temp.saveToDB();
		System.out.println("Zmieniono dane!");

	}

	private static void addUser() {
		createUser().saveToDB();
		System.out.println("Dodano!");

	}

	private static User createUser() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Podaj nazwę użytkownika:");
		String username = scan.nextLine();

		System.out.println("Podaj email:");
		String email = scan.nextLine();

		System.out.println("Podaj password:");
		String password = scan.nextLine();

		System.out.println("Podaj grupę:");
		int user_group_id = scan.nextInt();

		User newUser = new User(user_group_id, username, email, password);
		return newUser;
	}

	static int getId(Scanner scan) {
		int id = 0;
		List<User> uList = User.loadAll();
		List<Integer> idList = new ArrayList<>();
		for (User user : uList) {
			int uId = user.getId();
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

	static void printUsers() {
		System.out.println("Lista dostępnych Userów");
		List<User> userList = User.loadAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
